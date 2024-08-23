package controlador;

import conexion.Conexion;
import modelo.Bebida;
import modelo.Comida;
import modelo.Producto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Flores
 */
public class productoController {

    private static List<Producto> productos = new ArrayList<>();

    //private static List<Producto> productos = new ArrayList<>();
    public static List<Producto> listarProductos() {
        List<Producto> listProduct = new ArrayList<>();
        Conexion con = new Conexion();
        Connection condb = (Connection) con.conectar();
        if (condb != null) {
            try {
                String sql = "{CALL SP_ListarProductos}";
                CallableStatement stmt = condb.prepareCall(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Producto productos = new Producto(
                            rs.getString("id_producto"),
                            rs.getString("nombre"),
                            rs.getInt("Stock"),
                            rs.getString("tipo")
                    ) {
                        @Override
                        public double getPrecio() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        @Override
                        public void aplicarDescuento(double porcentajeDescuento) {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        @Override
                        public void aplicarPromocion(double porcentajeDescuento) {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    };
                    listProduct.add(productos);
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            }
        }
        return listProduct;
    }

    public boolean registrarProducto(Producto objProducto) {
        String sql = "{call sp_insertarProducto(?, ?, ?, ?)}";
        Conexion conectdb = new Conexion();
        try (Connection condb = conectdb.conectar(); CallableStatement callableStatement = condb.prepareCall(sql)) {
            callableStatement.setString(1, objProducto.getId_producto());
            callableStatement.setString(2, objProducto.getNombre());
            callableStatement.setInt(3, objProducto.getStock());
            callableStatement.setString(4, objProducto.getTipo());

            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarProducto(Producto objProducto) {
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            CallableStatement cs = condb.prepareCall("{call sp_modificarProducto(?,?,?,?)}");
            cs.setString(1, objProducto.getId_producto());
            cs.setString(2, objProducto.getNombre());
            cs.setInt(3, objProducto.getStock());
            cs.setString(4, objProducto.getTipo());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean EliminarProducto(Producto objProducto) {
        Conexion micondb = new Conexion();
        Connection db = micondb.conectar();
        try {
            CallableStatement callStat = db.prepareCall("{call sp_eliminarProducto(?)}");
            callStat.setString(1, objProducto.getId_producto());
            return callStat.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void inicializarDatosDeEjemplo() {
        productos.add(new Bebida("pr01", "Frappé Mocca Baileys", 12, "Bebida", 18.00, 500, false));
        productos.add(new Bebida("pr02", "Smoothie Baileys", 12, "Bebida", 18.00, 330, false));
        productos.add(new Comida("pr03", "Croissant de Pistacchio", 12, "Comida", 16.00, 800, "Croissant de Mantequilla, Cremoso de Pistacchios, Pistacchios Tostados.", "Ninguno"));
        productos.add(new Comida("pr04", "Croissant de Manjar", 12, "Comida", 12.00, 200, "Croissant de Mantequilla, Relleno de Manjar de Olla.", "Ninguno"));
        /* clientes.add(new Cliente("Juan", "Pérez", 12345678, "Masculino", 5551234, "cl01"));
        clientes.add(new Cliente("María", "García", 87654321, "Femenino", 5555678, "cl02"));*/
        //clientes.add(new Cliente("C001","flores",48235487,"M",944523658,"E001"));
        // empleados.add(new Empleado("em01", "Rodrigo", "Montes", 2312343, "Los olivos", "Venezuela", "Mesero","admin","admin123"));
        //promociones.add(new Promocion("Veraniego", 50, productos));
    }

    public static List<Comida> ListarPorductosComida(String tipoProducto) {
        String query = "{CALL SP_ListarProductosxComida(?)}";
        List<Comida> listProductComida = new ArrayList<>();
        Conexion conect = new Conexion();
        Connection con = conect.conectar();
        try {
            CallableStatement call = con.prepareCall(query);
            call.setString(1, tipoProducto);
            ResultSet result = call.executeQuery();
            while (result.next()) {
                Comida productComida = new Comida(
                        result.getString("Codigo"),
                        result.getString("Producto"),
                        result.getInt("Stock"),
                        result.getString("Tipo"),
                        result.getDouble("Precio"),
                        result.getInt("Calorias"),
                        result.getString("Ingredientes"),
                        result.getString("Alergenos")
                );
                listProductComida.add(productComida);
            }
        } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            }

        return listProductComida;
    }
        public static List<Bebida> ListarPorductosBebida(String tipoProducto) {
        String query = "{CALL SP_ListarProductosBebida(?)}";
        List<Bebida> listProductBebida = new ArrayList<>();
        Conexion conect = new Conexion();
        Connection con = conect.conectar();
        try {
            CallableStatement call = con.prepareCall(query);
            call.setString(1, tipoProducto);
            ResultSet result = call.executeQuery();
            while (result.next()) {
                Bebida productBebida = new Bebida(
                        result.getString("Codigo"),
                        result.getString("Producto"),
                        result.getInt("Stock"),
                        result.getString("Tipo"),
                        result.getDouble("Precio"),
                        result.getDouble("volumen"),
                        result.getBoolean("alcoholica")
                );
                listProductBebida.add(productBebida);
            }
        } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            }

        return listProductBebida;
    }
}
