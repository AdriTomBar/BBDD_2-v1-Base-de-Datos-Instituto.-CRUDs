import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import data.DaoDepartamento;
import data.models.Departamento;

public class Main {

    public final static String URL = "jdbc:mysql://localhost:3306/instituto";
    public final static String USER = "adrian";
    public final static String PASSWORD = "mysqlAdmin";
    public static void main(String[] args) {
        DaoDepartamento dp = new DaoDepartamento();
        probarConexion();

        Departamento d = new Departamento();
        d.setCod_departamento("111");
        d.setDescripcion("Prueba");
        d.setNombre("Pruebas");
        //dp.create(d);
        d = dp.read("111");
        System.out.println(d);

    }
    
    private static void probarConexion(){
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}