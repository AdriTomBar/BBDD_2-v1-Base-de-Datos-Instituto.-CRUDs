package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.models.Aula;

public class DaoAula extends JdbcDao<Aula,String> {
    private String SQL_INSERT = "INSERT INTO aula values(?,?)";
    private String SQL_DELETE = "DELETE FROM aula where num_aula=?";
    private String SQL_UPDATE = "UPDATE aula set cod_edificio=?,where num_aula=?";
    private String SQL_READ = "SELECT * FROM aula where num_aula=?";
    @Override
    protected PreparedStatement getInsertStatement(Aula model, Connection con) throws SQLException {
        PreparedStatement sr = con.prepareStatement(SQL_INSERT);
        sr.setString(1, model.getNum_aula());
        sr.setString(2, model.getCod_edificio());

        return sr;

    }

    @Override
    protected Aula getModelFromResultSet(ResultSet rs) throws SQLException {
        Aula aula = new Aula();
        aula.setNum_aula(rs.getString("num_aula"));
        aula.setCod_edificio(rs.getString("cod_edificio"));
        return aula;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Aula model, Connection conexion) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getCod_edificio());
        ps.setString(2, model.getNum_aula());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }
    

}
