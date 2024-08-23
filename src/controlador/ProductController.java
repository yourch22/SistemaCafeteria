package controlador;
import conexion.Conexion;
import modelo.ModelProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    // Crear Producto
    public boolean createProducto(ModelProductos producto) {
        Connection conn = new Conexion().conectar();
        String sql = "INSERT INTO Producto (id_producto, nombre, Stock, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getIdProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getTipo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Leer Producto
    public ModelProductos readProducto(String idProducto) {
        Connection conn = new Conexion().conectar();
        String sql = "SELECT * FROM Producto WHERE id_producto = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ModelProductos(rs.getString("id_producto"), rs.getString("nombre"), rs.getInt("Stock"), rs.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar Producto
    public boolean updateProducto(ModelProductos producto) {
        Connection conn = new Conexion().conectar();
        String sql = "UPDATE Producto SET nombre = ?, Stock = ?, tipo = ? WHERE id_producto = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setInt(2, producto.getStock());
            pstmt.setString(3, producto.getTipo());
            pstmt.setString(4, producto.getIdProducto());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar Producto
    public boolean deleteProducto(String idProducto) {
        Connection conn = new Conexion().conectar();
        String sql = "DELETE FROM Producto WHERE id_producto = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idProducto);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos los Productos
    public List<ModelProductos> getAllProductos() {
        Connection conn = new Conexion().conectar();
        List<ModelProductos> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new ModelProductos(rs.getString("id_producto"), rs.getString("nombre"), rs.getInt("Stock"), rs.getString("tipo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
