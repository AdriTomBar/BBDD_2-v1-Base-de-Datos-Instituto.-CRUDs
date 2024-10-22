package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JdbcDao<T,S> implements Dao<T,S> {

    String URL = "jdbc:mysql://localhost:3306/instit";
    String USER = "adrian";
    String PASSWORD = "mysqlAdmin";

    protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

    @Override
    public void create(T model) {
        try (Connection con = getConnection();
            PreparedStatement ps = getInsertStatement(model, con)){

            int numFilas = ps.executeUpdate();
            
            if (numFilas > 0) {
                System.out.println("Se ha insertado " + numFilas + " fila");
            } else {
                System.out.println("No se ha insertado ninguna fila");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected abstract PreparedStatement getInsertStatement(T model, Connection con) throws SQLException;

    @Override
    public T read(S id) {
        try (Connection con = getConnection();
        PreparedStatement st = getReadStatement(id,con);
        ResultSet rs = st.executeQuery()){
            
            if (rs.next()) {
                return getModelFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected abstract T getModelFromResultSet(ResultSet rs) throws SQLException;
    protected abstract PreparedStatement getReadStatement(S id, Connection con) throws SQLException;

    @Override
    public void update(T model) {
        try (Connection con = getConnection();
            PreparedStatement preparedStatement = getUpdateStatement(model, con)){
            
                int num_filas = preparedStatement.executeUpdate();

                if (num_filas == 0) {
                    System.err.println("No se ha podido actualizar el registro");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement getUpdateStatement(T model, Connection conexion) throws SQLException;

    @Override
    public void delete(S id) {
        try (Connection con = getConnection();
            PreparedStatement preparedStatement = getDeleteStatement(id, con)){
            
                int num = preparedStatement.executeUpdate();

                if (num > 0) {
                    System.out.println("Eliminado con exito");
                }else System.err.println("Error al eliminar el registro");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement getDeleteStatement(S id, Connection con) throws SQLException;
    
    
}
