package controlador;
import conexion.Conexion;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Flores
 */
public class clienteController {

    public List<Cliente> ListarClientes() {
        List<Cliente> listClientes = new ArrayList<>();
        String queryClientes = "{CALL sp_ListarClientes}";
        Conexion con = new Conexion();
        Connection condb = con.conectar();

        try (CallableStatement stmt = condb.prepareCall(queryClientes); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Cliente addCliente = new Cliente(
                        rs.getString("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("dni"),
                        rs.getString("genero"),
                        rs.getInt("numeroCelular"),
                        rs.getString("id_empleado")
                );
                listClientes.add(addCliente);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
        }
        return listClientes;
    }

    public boolean RegistrarClientes(Cliente Objcliente) {
        String consultaCliente = "{CALL sp_insertarClientes(?,?,?,?,?,?,?)}";
        Conexion conct = new Conexion();
        try (Connection conecdb = conct.conectar(); CallableStatement call = conecdb.prepareCall(consultaCliente)) {
            call.setString(1, Objcliente.getId_cliente());
            call.setString(2, Objcliente.getNombre());
            call.setString(3, Objcliente.getApellido());
            call.setInt(4, Objcliente.getDNI());
            call.setString(5, Objcliente.getGenero());
            call.setInt(6, Objcliente.getNumeroCelular());
            call.setString(7, Objcliente.getId_empleado());
            return call.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCliente(Cliente objCliente) {
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            CallableStatement cs = condb.prepareCall("{call sp_modificarCliente(?,?,?,?,?,?)}");
           cs.setString(1, objCliente.getId_cliente());
            cs.setString(2, objCliente.getNombre());
            cs.setString(3, objCliente.getApellido());
            cs.setInt(4, objCliente.getDNI());
            cs.setInt(5, objCliente.getNumeroCelular());
            cs.setString(6, objCliente.getId_empleado());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public boolean eliminarCliente(Cliente objCliente) {
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            CallableStatement cs = condb.prepareCall("{call sp_EliminarClientes(?)}");
           cs.setString(1, objCliente.getId_cliente());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
