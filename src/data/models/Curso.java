package data.models;

public class Curso {
    private String cod_curso;
    private String nombre;
    private String descripcion;    

    public Curso(String cod_curso, String nombre, String descripcion) {
        this.cod_curso = cod_curso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    public Curso() {
        //TODO Auto-generated constructor stub
    }


    public String getCod_curso() {
        return cod_curso;
    }


    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Curso [cod_curso=" + cod_curso + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
    }

}
