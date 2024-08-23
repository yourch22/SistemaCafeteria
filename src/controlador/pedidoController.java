/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import modelo.Producto;
import modelo.Pedidos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Flores
 */
public class pedidoController {

    public boolean registrarPedidos(Pedidos objPedidos) {
        String sql = "{call objPedidos(?, ?, ?, ?, ?, ?, ?)}";
        Conexion conectdb = new Conexion();
        try (Connection condb = conectdb.conectar(); CallableStatement callableStatement = condb.prepareCall(sql)) {
            callableStatement.setInt(1, objPedidos.getId_pedido());
            callableStatement.setInt(2, objPedidos.getCantidad());
            callableStatement.setDouble(3, objPedidos.getPrecio());
            callableStatement.setDouble(4, objPedidos.getImporte());
            callableStatement.setString(5, objPedidos.getId_producto());
            callableStatement.setString(6, objPedidos.getId_empleado());
            callableStatement.setString(7, objPedidos.getId_cliente());

            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public DefaultTableModel obtenerPedidos() {
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
            String sql = "{call sp_ListPedidos}";
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

    public boolean eliminarPedidos(Pedidos objPedidos) {
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            CallableStatement cs = condb.prepareCall("{call sp_EliminarPedido(?)}");
            cs.setInt(1, objPedidos.getId_pedido());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
