import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public final static String URL = "jdbc:mysql://localhost:3306/instituto";
    public final static String USER = "adrian";
    public final static String PASSWORD = "mysqlAdmin";
    public static void main(String[] args) {
        probarConexion();
    }
    
    private static void probarConexion(){
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}