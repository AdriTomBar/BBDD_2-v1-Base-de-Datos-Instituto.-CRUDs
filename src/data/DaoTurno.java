package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.models.Turno;

public class DaoTurno extends JdbcDao<Turno,String>{
    private final String SQL_INSERT = "INSERT INTO turno values(?,?)";
    private final String SQL_READ = "SELECT * FROM turno WHERE cod_turno = ?";
    private final String SQL_DELETE = "DELETE FROM turno WHERE cod_turno = ?";
    private final String SQL_UPDATE = "UPDATE turno set cod_turno=?,horario=?";

    @Override
    protected PreparedStatement getInsertStatement(Turno model, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        ps.setString(1, model.getCod_turno());
        ps.setString(2, model.getHorario());
        return ps;
    }

    @Override
    protected Turno getModelFromResultSet(ResultSet rs) throws SQLException {
        Turno turno = new Turno();
        turno.setCod_turno(rs.getString("cod_turno"));
        turno.setHorario(rs.getString("horario"));
        return turno;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Turno model, Connection conexion) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getCod_turno());
        ps.setString(2, model.getHorario());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }
    
}
