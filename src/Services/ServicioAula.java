package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DaoAula;
import data.models.Aula;

public class ServicioAula implements Servicio<Aula,String>{
    DaoAula daoAula = new DaoAula();
    @Override
    public void create(Aula objeto) {
        if (!validarDB(objeto) && comprobarEdificio(objeto)) {
            
            daoAula.create(objeto);
        } else {
            System.out.println("No se pudo crear el aula comprueba que el aula no exista en la base de datos y que el edificio exista");
        }
    }

    @Override
    public Aula read(String identificador) {
        if (identificador.length() > 0 && validarDB(identificador)) {
            return daoAula.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Aula objeto) {
        if (validarDB(objeto) && comprobarEdificio(objeto)) {
            daoAula.update(objeto);
            System.out.println("Aula actualizada");
        } else {
            System.out.println("No se pudo actualizar el aula comprueba que el aula exista en la base de datos y que el edificio exista");
        }
    }

    @Override
    public void delete(String identificador) {
        if (identificador.length() > 0 && (validarDB(identificador))) {
            
            daoAula.delete(identificador);
        } else {
            System.out.println("No se pudo eliminar el aula");
        }
    }

    private Boolean validarDB(Aula aula){
        
        if (daoAula.read(aula.getNum_aula()) != null) {
            System.out.println("El aula ya existe en la base de datos");
            return true;
            
        }
        return false;
    }

    private Boolean validarDB(String aula){
        
        if (daoAula.read(aula) != null) {
            System.out.println("El aula ya existe en la base de datos");
            return true;
        }
        return false;
    }
    
    private boolean comprobarEdificio(Aula aula) {
    	String sql = "SELECT cod_edificio from edificio";
        try(Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("cod_edificio").equals(aula.getCod_edificio())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }

     protected Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/instituto";
        String USER = "adrian";
        String PASSWORD = "mysqlAdmin";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
