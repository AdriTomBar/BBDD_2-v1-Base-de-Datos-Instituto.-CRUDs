package Services;

import data.DaoCurso;
import data.models.Curso;

public class ServicioCurso implements Servicio<Curso,String>{
    DaoCurso daoCurso = new DaoCurso();
    @Override
    public void create(Curso objeto) {
        if (!evalidarDB(objeto)) {
            daoCurso.create(objeto);
        } else {
            System.out.println("No se pudo crear el curso");
        }
    }

    @Override
    public Curso read(String identificador) {
        if (evalidarDB(identificador)) {
            return daoCurso.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Curso objeto) {
        if (evalidarDB(objeto) == false) {
            daoCurso.update(objeto);
        } else {
            System.out.println("No se pudo actualizar el curso");
        }
    }

    @Override
    public void delete(String identificador) {
        if (evalidarDB(identificador)==false) {
            daoCurso.delete(identificador);
        } else {
            System.out.println("No se pudo eliminar el curso");
        }
    }

    private Boolean evalidarDB(Curso curso){
        if (daoCurso.read(curso.getCod_curso()) != null) {
            System.out.println("El curso ya existe en la base de datos");
            return true;
        }
        return false;
    }

    private Boolean evalidarDB(String curso){
        if (daoCurso.read(curso) != null) {
            System.out.println("El curso ya existe en la base de datos");
            return true;
        }
        return false;
    }


   
    
}
