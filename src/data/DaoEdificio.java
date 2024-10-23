package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.models.Edificio;

public class DaoEdificio extends JdbcDao<Edificio,String>{
    private String SQL_INSERT = "INSERT INTO edificio values(?,?)";
    private String SQL_DELETE = "DELETE FROM edificio where cod_edificio=?";
    private String SQL_UPDATE = "UPDATE edificio set nombre=? where cod_edificio=?";
    private String SQL_READ = "SELECT * FROM edificio where cod_edificio=?";

    @Override
    protected PreparedStatement getInsertStatement(Edificio model, Connection con) throws SQLException {
        PreparedStatement sr = con.prepareStatement(SQL_INSERT);
        sr.setString(1, model.getCod_edificio());
        sr.setString(2, model.getNombre());

        return sr;
    }

    @Override
    protected Edificio getModelFromResultSet(ResultSet rs) throws SQLException {
        Edificio edificio = new Edificio();
        edificio.setCod_edificio(rs.getString("cod_edificio"));
        edificio.setNombre(rs.getString("nombre"));
        return edificio;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Edificio model, Connection conexion) throws SQLException {
     
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getNombre());
        ps.setString(2, model.getCod_edificio());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }
    
}
