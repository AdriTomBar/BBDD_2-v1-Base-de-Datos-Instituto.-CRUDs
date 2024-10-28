package Services;

import data.DaoAlumno;
import data.models.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicioAlumno implements Servicio<Alumno, String> {

    DaoAlumno daoAlumno = new DaoAlumno();

    @Override
    public void create(Alumno objeto) {
        if (validarDB(objeto.getNre()) && comprobarFecha(objeto.getFecha_nac()) && comprobarCodPostal(objeto)) {
            daoAlumno.create(objeto);
            System.out.println("El alumno se ha creado en la base de datos");
        } else {
            System.out.println(
                    "No se pudo crear el alumno, comprueba que el alumno no exista en la base de datos y que el código postal sea correcto");
        }
    }

    @Override
    public Alumno read(String identificador) {
        if (!validarDB(identificador)) {
            Alumno a = daoAlumno.read(identificador);
            return a;
        }
        return null;
    }

    @Override
    public void update(Alumno objeto) {
        if (!validarDB(objeto.getNre()) && comprobarFecha(objeto.getFecha_nac()) && comprobarCodPostal(objeto)) {
            daoAlumno.update(objeto);
            System.out.println("El alumno se ha actualizado en la base de datos");
        } else {
            System.out.println("No se pudo actualizar el alumno, comprueba que el alumno exista en la base de datos");
            
        }
    }

    @Override
    public void delete(String identificador) {
        if (!validarDB(identificador)) {
            daoAlumno.delete(identificador);
        }
    }

    private Boolean validarDB(String nre) {
        if (daoAlumno.read(nre) != null) {
            System.out.println("Alumno registrado en la base de datos");
            return false;
        }
        return true;
    }

    private boolean comprobarFecha(String fechaNac) {
        try {
            LocalDate fecha = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            // Verificar que la fecha no sea mayor a la fecha actual
            if (fecha.isAfter(LocalDate.now())) {
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean comprobarCodPostal(Alumno a) {
        String sql = "SELECT * FROM alumno WHERE cp = ?";
        try (Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getCp().trim());
            ResultSet rs = stmt.executeQuery();
            try {
                if (rs.next()) {
                    System.out.println("El código postal existe en la base de datos");
                    return true;
                }
                System.out.println("El código postal no existe en la base de datos");
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            return false;

        }
    }

    protected Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/instituto";
        String USER = "adrian";
        String PASSWORD = "mysqlAdmin";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}