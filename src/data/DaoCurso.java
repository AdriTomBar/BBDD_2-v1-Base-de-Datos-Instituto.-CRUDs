package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.models.Curso;

public class DaoCurso extends JdbcDao<Curso,String>{
    private final String SQL_INSERT = "INSERT INTO curso values(?,?,?)";
    private final String SQL_DELETE = "DELETE FROM curso where cod_curso=?";
    private final String SQL_UPDATE = "UPDATE curso set nombre=?,descripcion=? where cod_curso=?";
    private final String SQL_READ = "SELECT * FROM curso where cod_curso=?";
    
    @Override
    protected PreparedStatement getInsertStatement(Curso model, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        ps.setString(1, model.getCod_curso());
        ps.setString(2, model.getNombre());
        ps.setString(3, model.getDescripcion());
        return ps;
    }

    @Override
    protected Curso getModelFromResultSet(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        curso.setCod_curso(rs.getString("cod_curso"));
        curso.setNombre(rs.getString("nombre"));
        curso.setDescripcion(rs.getString("descripcion"));
        return curso;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Curso model, Connection conexion) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getNombre());
        ps.setString(2, model.getDescripcion());
        ps.setString(3, model.getCod_curso());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }

    public Curso crearCurso() {
        Curso curso = new Curso();
        curso.setCod_curso("C1");
        curso.setNombre("Curso 1");
        curso.setDescripcion("Descripcion del curso 1");
        return curso;
    }

}
