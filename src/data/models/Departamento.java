package data.models;

public class Departamento {
    private String cod_departamento;
    private String nombre;
    private String descripcion;

    public Departamento(String cod_departamento, String nombre, String descripcion) {
        this.cod_departamento = cod_departamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento [cod_departamento=" + cod_departamento + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
    }
}
