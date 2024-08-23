package controlador;

import modelo.PromocionProduct;
import conexion.Conexion;
import modelo.Producto;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Flores
 */
public class PromocionController {

    private static final String INSERT_PROMOTION_SQL = "INSERT INTO Promocion (descripcion, porcentaje_descuento) VALUES (?, ?)";

    public int addPromotion(PromocionProduct promotion) {
        Conexion DatabaseConnection = new Conexion();
        int promotionId = -1;
        try (Connection connection = DatabaseConnection.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROMOTION_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, promotion.getDescripcion());
            preparedStatement.setDouble(2, promotion.getPorcentaje_descuento());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        promotionId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotionId;
    }

    public void addPromotionToProducts(int id_promocion, List<String> productIds) {
        String queryDelete = "DELETE FROM PromocionProducto WHERE id_promocion = ? AND id_producto = ?";
        String queryInsert = "INSERT INTO PromocionProducto (id_promocion, id_producto) VALUES (?, ?)";

        try (Connection con = new Conexion().conectar(); PreparedStatement pstmtDelete = con.prepareStatement(queryDelete); PreparedStatement pstmtInsert = con.prepareStatement(queryInsert)) {

            for (String id_producto : productIds) {
                // Eliminar la asociación existente, si existe
                pstmtDelete.setInt(1, id_promocion);
                pstmtDelete.setString(2, id_producto);
                pstmtDelete.executeUpdate();

                // Luego, agregar la nueva asociación
                pstmtInsert.setInt(1, id_promocion);
                pstmtInsert.setString(2, id_producto);
                pstmtInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean productoExistente(Connection con, int id_promocion, String id_producto) throws SQLException {
        String query = "SELECT * FROM PromocionProducto WHERE id_promocion = ? AND id_producto = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id_promocion);
            pstmt.setString(2, id_producto);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retorna true si el producto ya existe en la promoción
            }
        }
    }

    public DefaultTableModel obtenerProductosConPromocion() {
        /* Connection conn = new Conexion().conectar();
        CallableStatement stmt = conn.prepareCall("{call sp_ObtenerProductosConPromocion}");
        return stmt.executeQuery();*/
        CallableStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel tableModel = null;
        try {
            // Conexión a la base de datos
            Connection conn = new Conexion().conectar();
            // Llamada al procedimiento almacenado
            String sql = "{call sp_ObtenerProductosConPromocion}";
            stmt = conn.prepareCall(sql);
            // Ejecución y obtención de resultados
            rs = stmt.executeQuery();

            // Preparación del modelo de la tabla
            ResultSetMetaData metaData = rs.getMetaData();

            // Nombre de las columnas
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int column = 0; column < columnCount; column++) {
                columnNames[column] = metaData.getColumnName(column + 1);
            }

            // Datos de las filas
            tableModel = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 0; column < columnCount; column++) {
                    row[column] = rs.getObject(column + 1);
                }
                tableModel.addRow(row);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return tableModel;
    }

    public boolean EliminarPromocion(Producto objproducto){
        Conexion micondb = new  Conexion();
        Connection db = micondb.conectar();
        try{CallableStatement callStat = db.prepareCall("{call SP_EliminarPromocion(?)}");
        callStat.setString(1, objproducto.getId_producto());
        return callStat.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        return false;
        }
    }
}

