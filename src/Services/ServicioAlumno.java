package Services;

import data.Dao;
import data.DaoAlumno;
import data.models.Alumno;

public class ServicioAlumno implements Servicio<Alumno,String>{

    DaoAlumno daoAlumno = new DaoAlumno();

    @Override
    public void create(Alumno objeto) {
        if (validarDB(objeto)) {
            daoAlumno.create(objeto);
            System.out.println("El alumno se ha creado en la base de datos");
        }
    }

    @Override
    public Alumno read(String identificador) {
        if (validarDB(identificador)) {
            Alumno a = daoAlumno.read(identificador);
            System.out.println("El alumno se ha leido de la base de datos");
            return a;
        }
        return null;
    }

    @Override
    public void update(Alumno objeto) {
        if (validarDB(objeto)) {
            daoAlumno.update(objeto);
            System.out.println("El alumno se ha actualizado en la base de datos");
        }
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            daoAlumno.delete(identificador);
            System.out.println("El alumno se ha eliminado de la base de datos");
        }  
    }
    
    private Boolean validarDB(Alumno alumno){
        if (alumno.getNre() != null) {
            System.out.println("El alumno ya existe en la base de datos");
        }
        return true;
    }

    private Boolean validarDB(String alumno){
        DaoAlumno daoAlumno = new DaoAlumno();
        if ( daoAlumno.read(alumno)!= null) {
            System.out.println("El alumno ya existe en la base de datos");
        }
        return true;
    }
}
