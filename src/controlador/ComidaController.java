/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import conexion.Conexion;
import modelo.Comida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Flores
 */

public class ComidaController {
    private Conexion conexion;

    public ComidaController() {
        conexion = new Conexion();
    }

    public void createComida(Comida comida) {
        String sqlProducto = "INSERT INTO Producto (id_producto, nombre, Stock, tipo) VALUES (?, ?, ?, ?)";
        String sqlComida = "INSERT INTO Comida (id_producto, precio, calorias, ingredientes, alergenos) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Insertar en Producto
            try (PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto)) {
                pstmtProducto.setString(1, comida.getId_producto());
                pstmtProducto.setString(2, comida.getNombre());
                pstmtProducto.setInt(3, comida.getStock());
                pstmtProducto.setString(4, comida.getTipo());
                pstmtProducto.executeUpdate();
            }

            // Insertar en Comida
            try (PreparedStatement pstmtComida = conn.prepareStatement(sqlComida)) {
                pstmtComida.setString(1, comida.getId_producto());
                pstmtComida.setDouble(2, comida.getPrecio());
                pstmtComida.setInt(3, comida.getCalorias());
                pstmtComida.setString(4, comida.getIngredientes());
                pstmtComida.setString(5, comida.getAlergenos());
                pstmtComida.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comida> getAllComidas() {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT p.id_producto, p.nombre, p.Stock, p.tipo, c.precio, c.calorias, c.ingredientes, c.alergenos FROM Producto p JOIN Comida c ON p.id_producto = c.id_producto";
        try (Connection conn = conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Comida comida = new Comida(
                        rs.getString("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("Stock"),
                        rs.getString("tipo"),
                        rs.getDouble("precio"),
                        rs.getInt("calorias"),
                        rs.getString("ingredientes"),
                        rs.getString("alergenos")
                );
                comidas.add(comida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comidas;
    }

    public void updateComida(Comida comida) {
        String sqlProducto = "UPDATE Producto SET nombre = ?, Stock = ?, tipo = ? WHERE id_producto = ?";
        String sqlComida = "UPDATE Comida SET precio = ?, calorias = ?, ingredientes = ?, alergenos = ? WHERE id_producto = ?";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Actualizar en Producto
            try (PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto)) {
                pstmtProducto.setString(1, comida.getNombre());
                pstmtProducto.setInt(2, comida.getStock());
                pstmtProducto.setString(3, comida.getTipo());
                pstmtProducto.setString(4, comida.getId_producto());
                pstmtProducto.executeUpdate();
            }

            // Actualizar en Comida
            try (PreparedStatement pstmtComida = conn.prepareStatement(sqlComida)) {
                pstmtComida.setDouble(1, comida.getPrecio());
                pstmtComida.setInt(2, comida.getCalorias());
                pstmtComida.setString(3, comida.getIngredientes());
                pstmtComida.setString(4, comida.getAlergenos());
                pstmtComida.setString(5, comida.getId_producto());
                pstmtComida.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComida(String idProducto) {
        String sqlComida = "DELETE FROM Comida WHERE id_producto = ?";
        String sqlProducto = "DELETE FROM Producto WHERE id_producto = ?";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Eliminar en Comida
            try (PreparedStatement pstmtComida = conn.prepareStatement(sqlComida)) {
                pstmtComida.setString(1, idProducto);
                pstmtComida.executeUpdate();
            }

            // Eliminar en Producto
            try (PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto)) {
                pstmtProducto.setString(1, idProducto);
                pstmtProducto.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
