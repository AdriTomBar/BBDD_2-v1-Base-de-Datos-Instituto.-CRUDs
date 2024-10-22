package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.models.Alumno;

public class DaoAlumno extends JdbcDao<Alumno,String>{
    private final String SQL_INSERT = "INSERT INTO alumno values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_READ = "SELECT * FROM alumno WHERE nrp = ?";
    private final String SQL_DELETE = "DELETE FROM alumno WHERE nrp = ?";
    private final String SQL_UPDATE = "UPDATE alumno set nombre=?,apellido1=?,apellido2=?,dni=?,tipo_via=?,nombre_via=?,numero=?,escalera=?,piso=?,puerta=?,cp=?,pais=?,tlfn_fijo=?,tlfn_movil=?,email=?,fecha_nac=?,cod_departamento=?,where nrp=?";
    
    @Override
    protected PreparedStatement getInsertStatement(Alumno model, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        ps.setString(1, model.getNrp());
        ps.setString(2, model.getNombre());
        ps.setString(3, model.getApellido1());
        ps.setString(4, model.getApellido2());
        ps.setString(5, model.getDni());
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
        ps.setDate(17, model.getFecha_nac());
        ps.setString(18, model.getCod_departamento());
        return ps;
    }

    @Override
    protected Alumno getModelFromResultSet(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setNrp(rs.getString("nrp"));
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
        alumno.setFecha_nac(rs.getDate("fecha_nac"));
        alumno.setCod_departamento(rs.getString("cod_departamento"));
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
        ps.setDate(16, model.getFecha_nac());
        ps.setString(17, model.getCod_departamento());
        ps.setString(18, model.getNrp());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);  
        return ps;
    }
    
}
