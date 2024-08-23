package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jorge Flores
 */
public class Conexion {

    private String connectionUrl;
    private java.sql.Connection connection;
     private String usuario = "jorge";
     private String password = "jorge123";
     private String baseDatos = "CafArmonicaa";
     private String servidor = "localhost";
     private int puerto = 1433;

    public Conexion() {
        this.connectionUrl = "jdbc:sqlserver://" + servidor + ":" + 
                puerto + ";databaseName=" + baseDatos + ";user=" + usuario + 
                ";password=" + password + ";encrypt=true;trustServerCertificate=true";
    }

    public Connection conectar() {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return (Connection) connection;
    }

    public void cerrar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión:");
                e.printStackTrace();
            }
        }
    }
}
