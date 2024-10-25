package Services;

import data.DaoCurso;
import data.models.Curso;

public class ServicioCurso implements Servicio<Curso,String>{

    @Override
    public void create(Curso objeto) {
        if (validarIdCurso(objeto)==true && evalidarDB(objeto) == false) {
            DaoCurso daoCurso = new DaoCurso();
            daoCurso.create(objeto);
        } else {
            System.out.println("No se pudo crear el curso");
        }
    }

    @Override
    public Curso read(String identificador) {
        if (identificador.length() > 0 && (evalidarDB(identificador)==false)) {
            DaoCurso daoCurso = new DaoCurso();
            return daoCurso.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Curso objeto) {
        if (validarIdCurso(objeto) && evalidarDB(objeto) == false) {
            DaoCurso daoCurso = new DaoCurso();
            daoCurso.update(objeto);
        } else {
            System.out.println("No se pudo actualizar el curso");
        }
    }

    @Override
    public void delete(String identificador) {
        if (identificador.length() > 0 && (evalidarDB(identificador)==false)) {
            DaoCurso daoCurso = new DaoCurso();
            daoCurso.delete(identificador);
        } else {
            System.out.println("No se pudo eliminar el curso");
        }
    }

    private Boolean evalidarDB(Curso curso){
        DaoCurso daoCurso = new DaoCurso();
        if (daoCurso.read(curso.getCod_curso()) != null) {
            throw new IllegalArgumentException("El curso ya existe en la base de datos");
        }
        return false;
    }

    private Boolean evalidarDB(String curso){
        DaoCurso daoCurso = new DaoCurso();
        if (daoCurso.read(curso) != null) {
            throw new IllegalArgumentException("El curso ya existe en la base de datos");
        }
        return false;
    }

    private Boolean validarIdCurso(Curso curso){
        if (curso.getCod_curso().length() < 1) {
            System.out.println("El id del curso debe tener al menos 1 caracter");
        }
        return true;
    }

   
    
}
