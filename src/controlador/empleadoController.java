package controlador;
import conexion.Conexion;
import modelo.Empleado;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.util.List;
/**
 * @author Jorge Flores
 */
public class empleadoController {
    private static List<Empleado> empleados = new ArrayList<>();
    public boolean LoginUser(Empleado empleados) {
        boolean respt = false;
        String query = "SELECT * FROM Empleado WHERE usuario = '" + empleados.getUsuario() + "' AND clave = '" + empleados.getClave() + "';";
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            PreparedStatement stmt = condb.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                respt = true;
            }
            condb.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respt;
    }
    
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        Conexion con = new Conexion();
        Connection condb = (Connection) con.conectar();
        if (condb != null) {
            try {
                String sql = "{CALL sp_ListarEmpleados}";
                CallableStatement stmt = condb.prepareCall(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Empleado empleado = new Empleado(
                            rs.getString("id_empleado"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("dni"),
                            rs.getString("direccion"),
                            rs.getString("pais"),
                            rs.getString("puesto"),
                            rs.getString("usuario"),
                            rs.getString("clave")
                    );
                    empleados.add(empleado);
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            }
        }
        return empleados;
    }
    public boolean registrarEmpleado(Empleado obj_empleado) {
        String sql = "{call sp_insertarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        Conexion conectdb = new Conexion();
        try (Connection condb = conectdb.conectar(); CallableStatement callableStatement = condb.prepareCall(sql)) {
            callableStatement.setString(1, obj_empleado.getId_empleado());
            callableStatement.setString(2, obj_empleado.getNombre());
            callableStatement.setString(3, obj_empleado.getApellido());
            callableStatement.setInt(4, obj_empleado.getDni());
            callableStatement.setString(5, obj_empleado.getDireccion());
            callableStatement.setString(6, obj_empleado.getPais());
            callableStatement.setString(7, obj_empleado.getPuesto());
            callableStatement.setString(8, obj_empleado.getUsuario());
            callableStatement.setString(9, obj_empleado.getClave());

            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean modificarEmpleado(Empleado objempleado) {
        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();
        try {
            CallableStatement cs = condb.prepareCall("{call sp_modificarEmpleado(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, objempleado.getId_empleado());
            cs.setString(2, objempleado.getNombre());
            cs.setString(3, objempleado.getApellido());
            cs.setInt(4, objempleado.getDni());
            cs.setString(5, objempleado.getDireccion());
            cs.setString(6, objempleado.getPais());
            cs.setString(7, objempleado.getPuesto());
            cs.setString(8, objempleado.getUsuario());
            cs.setString(9, objempleado.getClave());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean EliminarEmpleado(Empleado objempleado){
        Conexion micondb = new  Conexion();
        Connection db = micondb.conectar();
        try{CallableStatement callStat = db.prepareCall("{call sp_eliminarEmpleado(?)}");
        callStat.setString(1, objempleado.getId_empleado());
        return callStat.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        return false;
        }
    }
}
