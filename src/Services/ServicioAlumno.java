package Services;

import data.DaoAlumno;
import data.models.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicioAlumno implements Servicio<Alumno, String> {

    DaoAlumno daoAlumno = new DaoAlumno();

    @Override
    public void create(Alumno objeto) {
        if (validarDB(objeto) == true && comprobarCp(objeto) == true) {
            daoAlumno.create(objeto);
            System.out.println("El alumno se ha creado en la base de datos");
        }
        System.out.println("No se pudo crear el alumno, comprueba que el alumno no exista en la base de datos y que el código postal sea correcto");
    }

    @Override
    public Alumno read(String identificador) {
        if (validarDB(identificador)) {
            Alumno a = daoAlumno.read(identificador);
            System.out.println("El alumno se ha leido de la base de datos");
            return a;
        }
        return null;
    }

    @Override
    public void update(Alumno objeto) {
        if (validarDB(objeto) == false && comprobarCp(objeto) == true) {
            daoAlumno.update(objeto);
            System.out.println("El alumno se ha actualizado en la base de datos");
        }
        System.out.println("No se pudo actualizar el alumno, comprueba que el alumno exista en la base de datos y que el código postal sea correcto");
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            daoAlumno.delete(identificador);
            System.out.println("El alumno se ha eliminado de la base de datos");
        }
    }

    private Boolean validarDB(Alumno alumno) {
        if (alumno.getNre() != null) {
            System.out.println("Alumno registrado en la base de datos");
            return false;
        }
        return true;
    }

    private Boolean validarDB(String alumno) {
        DaoAlumno daoAlumno = new DaoAlumno();
        if (daoAlumno.read(alumno) != null) {
            System.out.println("Alumno registrado en la base de datos");
        }
        return true;
    }

    protected Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/instituto";
        String USER = "adrian";
        String PASSWORD = "mysqlAdmin";
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

    private boolean comprobarCp(Alumno a){
        ArrayList<String> cps = consultaCod_pos();
        for (String cp : cps) {
            if (cp.equals(a.getCp())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> consultaCod_pos(){
        ArrayList<String> cps = new ArrayList<>();  

        String sql = "SELECT cp from alumno";

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("cp"));
                cps.add(rs.getString("cp"));
            }
            return cps;

        } catch (Exception e) {
            e.printStackTrace();
        }      
        return cps;                                                             
    }

}
    
