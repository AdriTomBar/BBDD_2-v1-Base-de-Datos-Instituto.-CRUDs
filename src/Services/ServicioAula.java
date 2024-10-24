package Services;

import data.Dao;
import data.DaoAula;
import data.models.Aula;

public class ServicioAula implements Servicio<Aula,String>{

    @Override
    public void create(Aula objeto) {
        if (evalidarDB(objeto) == true) {
            DaoAula daoAula = new DaoAula();
            daoAula.create(objeto);
        } else {
            System.out.println("No se pudo crear el aula");
        }
    }

    @Override
    public Aula read(String identificador) {
        if (identificador.length() > 0 && (evalidarDB(identificador)==false)) {
            DaoAula daoAula = new DaoAula();
            return daoAula.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Aula objeto) {
        if (evalidarDB(objeto) == false) {
            DaoAula daoAula = new DaoAula();
            daoAula.update(objeto);
        } else {
            System.out.println("No se pudo actualizar el aula");
        }
    }

    @Override
    public void delete(String identificador) {
        if (identificador.length() > 0 && (evalidarDB(identificador)==false)) {
            DaoAula daoAula = new DaoAula();
            daoAula.delete(identificador);
        } else {
            System.out.println("No se pudo eliminar el aula");
        }
    }

    private Boolean evalidarDB(Aula aula){
        DaoAula daoAula = new DaoAula();
        if (daoAula.read(aula.getNum_aula()) != null) {
            throw new IllegalArgumentException("El aula ya existe en la base de datos");
        }
        return false;
    }

    private Boolean evalidarDB(String aula){
        DaoAula daoAula = new DaoAula();
        if (daoAula.read(aula) != null) {
            throw new IllegalArgumentException("El aula ya existe en la base de datos");
        }
        return false;
    }
    

}
