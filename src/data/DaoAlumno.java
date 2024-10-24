package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import data.models.Alumno;

public class DaoAlumno extends JdbcDao<Alumno, String> {
    private final String SQL_INSERT = "INSERT INTO alumno values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_READ = "SELECT * FROM alumno WHERE nre = ?";
    private final String SQL_DELETE = "DELETE FROM alumno WHERE nre = ?";
    private final String SQL_UPDATE = "UPDATE alumno set nombre=?,apellido1=?,apellido2=?,dni=?,tipo_via=?,nombre_via=?,numero=?,escalera=?,piso=?,puerta=?,cp=?,pais=?,tlfn_fijo=?,tlfn_movil=?,email=?,fecha_nac=?,tutor=? where nre=?";

    @Override
    protected PreparedStatement getInsertStatement(Alumno model, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        ps.setString(1, model.getNre());
        ps.setString(2, model.getDni());
        ps.setString(3, model.getNombre());
        ps.setString(4, model.getApellido1());
        ps.setString(5, model.getApellido2());
        ps.setString(6, model.getTipo_via());
        ps.setString(7, model.getNombre_via());
        ps.setString(8, model.getNumero());
        ps.setString(9, model.getEscalera());
        ps.setString(10, model.getPiso());
        ps.setString(11, model.getPuerta());
        ps.setString(12, model.getCp());
        ps.setString(13, model.getPais());
        ps.setString(14, model.getTlfn_fijo());
        ps.setString(15, model.getTlfn_movil());
        ps.setString(16, model.getEmail());
        ps.setString(17, model.getFecha_nac());
        ps.setString(18, model.gettutor());
        return ps;
    }

    @Override
    protected Alumno getModelFromResultSet(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setNre(rs.getString("nre"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido1(rs.getString("apellido1"));
        alumno.setApellido2(rs.getString("apellido2"));
        alumno.setDni(rs.getString("dni"));
        alumno.setTipo_via(rs.getString("tipo_via"));
        alumno.setNombre_via(rs.getString("nombre_via"));
        alumno.setNumero(rs.getString("numero"));
        alumno.setEscalera(rs.getString("escalera"));
        alumno.setPiso(rs.getString("piso"));
        alumno.setPuerta(rs.getString("puerta"));
        alumno.setCp(rs.getString("cp"));
        alumno.setPais(rs.getString("pais"));
        alumno.setTlfn_fijo(rs.getString("tlfn_fijo"));
        alumno.setTlfn_movil(rs.getString("tlfn_movil"));
        alumno.setEmail(rs.getString("email"));
        alumno.setFecha_nac(rs.getString("fecha_nac"));
        alumno.settutor(rs.getString("tutor"));
        return alumno;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Alumno model, Connection conexion) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getNombre());
        ps.setString(2, model.getApellido1());
        ps.setString(3, model.getApellido2());
        ps.setString(4, model.getDni());
        ps.setString(5, model.getTipo_via());
        ps.setString(6, model.getNombre_via());
        ps.setString(7, model.getNumero());
        ps.setString(8, model.getEscalera());
        ps.setString(9, model.getPiso());
        ps.setString(10, model.getPuerta());
        ps.setString(11, model.getCp());
        ps.setString(12, model.getPais());
        ps.setString(13, model.getTlfn_fijo());
        ps.setString(14, model.getTlfn_movil());
        ps.setString(15, model.getEmail());
        ps.setString(16, model.getFecha_nac());
        ps.setString(17, model.gettutor());
        ps.setString(18, model.getNre());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }

    public Alumno crearAlumno() {
        Scanner sc = new Scanner(System.in);
            Alumno alumno = new Alumno();
            System.out.println("Intruduzca un nrp");
            alumno.setNre(sc.next());
            System.out.println("Intruduzca un nombre");
            alumno.setNombre(sc.next());
            System.out.println("Intruduzca un apellido1");
            alumno.setApellido1(sc.next());
            System.out.println("Intruduzca un apellido2");
            alumno.setApellido2(sc.next());
            System.out.println("Intruduzca un dni");
            alumno.setDni(sc.next());
            System.out.println("Intruduzca un tipo_via");
            alumno.setTipo_via(sc.next());
            System.out.println("Intruduzca un nombre_via");
            alumno.setNombre_via(sc.next());
            System.out.println("Intruduzca un numero");
            alumno.setNumero(sc.next());
            System.out.println("Intruduzca un escalera");
            alumno.setEscalera(sc.next());
            System.out.println("Intruduzca un piso");
            alumno.setPiso(sc.next());
            System.out.println("Intruduzca un puerta");
            alumno.setPuerta(sc.next());
            System.out.println("Intruduzca un cp");
            alumno.setCp(sc.next());
            System.out.println("Intruduzca un pais");
            alumno.setPais(sc.next());
            System.out.println("Intruduzca un tlfn_fijo");
            alumno.setTlfn_fijo(sc.next());
            System.out.println("Intruduzca un tlfn_movil");
            alumno.setTlfn_movil(sc.next());
            System.out.println("Intruduzca un email");
            alumno.setEmail(sc.next());
            System.out.println("Intruduzca un fecha_nac (yyyy-mm-dd)");
            alumno.setFecha_nac(sc.next());
            while (!comprobarFecha(alumno.getFecha_nac())) {
                System.out.println("Fecha no válida, intruduzca un fecha_nac (yyyy-mm-dd)");
                alumno.setFecha_nac(sc.next());
            }
            System.out.println("Intruduzca un tutor");
            alumno.settutor(sc.next());
            return alumno;
        }

    private boolean comprobarFecha(String fecha) {
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }

}
