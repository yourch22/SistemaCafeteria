/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import modelo.Bebida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jorge Flores
 */
public class BebidaController {
    private Conexion conexion;

    public BebidaController() {
        conexion = new Conexion();
    }

    public void createBebida(Bebida bebida) {
        String sqlProducto = "INSERT INTO Producto (id_producto, nombre, Stock, tipo) VALUES (?, ?, ?, ?)";
        String sqlBebida = "INSERT INTO Bebida (id_producto, precio, volumen, alcoholica) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Insertar en Producto
            try (PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto)) {
                pstmtProducto.setString(1, bebida.getId_producto());
                pstmtProducto.setString(2, bebida.getNombre());
                pstmtProducto.setInt(3, bebida.getStock());
                pstmtProducto.setString(4, bebida.getTipo());
                pstmtProducto.executeUpdate();
            }

            // Insertar en Bebida
            try (PreparedStatement pstmtBebida = conn.prepareStatement(sqlBebida)) {
                pstmtBebida.setString(1, bebida.getId_producto());
                pstmtBebida.setDouble(2, bebida.getPrecio());
                pstmtBebida.setDouble(3, bebida.getVolumen());
                pstmtBebida.setBoolean(4, bebida.isAlcoholica());
                pstmtBebida.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bebida> getAllBebidas() {
        List<Bebida> bebidas = new ArrayList<>();
        String sql = "SELECT p.id_producto, p.nombre, p.Stock, p.tipo, b.precio, b.volumen, b.alcoholica FROM Producto p JOIN Bebida b ON p.id_producto = b.id_producto";
        try (Connection conn = conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bebida bebida = new Bebida(
                        rs.getString("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("Stock"),
                        rs.getString("tipo"),
                        rs.getDouble("precio"),
                        rs.getDouble("volumen"),
                        rs.getBoolean("alcoholica")
                );
                bebidas.add(bebida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bebidas;
    }

    public void updateBebida(Bebida bebida) {
        String sqlProducto = "UPDATE Producto SET nombre = ?, Stock = ?, tipo = ? WHERE id_producto = ?";
        String sqlBebida = "UPDATE Bebida SET precio = ?, volumen = ?, alcoholica = ? WHERE id_producto = ?";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Actualizar en Producto
            try (PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto)) {
                pstmtProducto.setString(1, bebida.getNombre());
                pstmtProducto.setInt(2, bebida.getStock());
                pstmtProducto.setString(3, bebida.getTipo());
                pstmtProducto.setString(4, bebida.getId_producto());
                pstmtProducto.executeUpdate();
            }

            // Actualizar en Bebida
            try (PreparedStatement pstmtBebida = conn.prepareStatement(sqlBebida)) {
                pstmtBebida.setDouble(1, bebida.getPrecio());
                pstmtBebida.setDouble(2, bebida.getVolumen());
                pstmtBebida.setBoolean(3, bebida.isAlcoholica());
                pstmtBebida.setString(4, bebida.getId_producto());
                pstmtBebida.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBebida(String idProducto) {
        String sqlBebida = "DELETE FROM Bebida WHERE id_producto = ?";
        String sqlProducto = "DELETE FROM Producto WHERE id_producto = ?";
        try (Connection conn = conexion.conectar()) {
            conn.setAutoCommit(false);

            // Eliminar en Bebida
            try (PreparedStatement pstmtBebida = conn.prepareStatement(sqlBebida)) {
                pstmtBebida.setString(1, idProducto);
                pstmtBebida.executeUpdate();
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
