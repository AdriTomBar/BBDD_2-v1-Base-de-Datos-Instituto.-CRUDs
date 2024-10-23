package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.models.Departamento;
import java.util.Scanner;

public class DaoDepartamento extends JdbcDao<Departamento, String> {
    private static String SQL_UPDATE = "UPDATE departamento set nombre=?,descripcion=? where cod_departamento = ?";
    private static String SQL_INSERT = "Insert into departamento values(?,?,?)";
    private static String SQL_READ = "Select * from departamento where cod_departamento = ?";
    private static String SQL_DELETE = " DELETE from departamento where cod_departamento = ?";

    @Override
    protected PreparedStatement getInsertStatement(Departamento model, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);

        ps.setString(1, model.getCod_departamento());
        ps.setString(2, model.getNombre());
        ps.setString(3, model.getDescripcion());

        return ps;
    }

    @Override
    protected Departamento getModelFromResultSet(ResultSet rs) throws SQLException {
        Departamento dp = new Departamento();

        dp.setCod_departamento(rs.getString("cod_departamento"));
        dp.setDescripcion(rs.getString("descripcion"));
        dp.setNombre(rs.getString("nombre"));

        return dp;
    }

    @Override
    protected PreparedStatement getReadStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_READ);
        ps.setString(1, id);
        return ps;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Departamento model, Connection conexion) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
        ps.setString(1, model.getNombre());
        ps.setString(2, model.getDescripcion());
        ps.setString(3, model.getCod_departamento());
        return ps;
    }

    @Override
    protected PreparedStatement getDeleteStatement(String id, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setString(1, id);
        return ps;
    }

    public Departamento crearDepartamento() {
        Departamento dp = new Departamento();
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in); // No cerrar Scanner(System.in)

        System.out.println("Introduzca el código del departamento:");
        String codDepartamento = sc.nextLine();
        while (codDepartamento.trim().isEmpty()) {
            System.out.println("El código no puede estar vacío. Inténtelo de nuevo:");
            codDepartamento = sc.nextLine();
        }
        dp.setCod_departamento(codDepartamento);

        System.out.println("Introduzca el nombre del departamento:");
        String nombreDepartamento = sc.nextLine();
        while (nombreDepartamento.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Inténtelo de nuevo:");
            nombreDepartamento = sc.nextLine();
        }
        dp.setNombre(nombreDepartamento);

        System.out.println("Introduzca la descripción del departamento:");
        String descripcionDepartamento = sc.nextLine();
        while (descripcionDepartamento.trim().isEmpty()) {
            System.out.println("La descripción no puede estar vacía. Inténtelo de nuevo:");
            descripcionDepartamento = sc.nextLine();
        }
        dp.setDescripcion(descripcionDepartamento);

        return dp;
    }

}
