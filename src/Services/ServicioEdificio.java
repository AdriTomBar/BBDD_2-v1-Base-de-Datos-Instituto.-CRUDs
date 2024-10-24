package Services;

import data.DaoEdificio;
import data.models.Edificio;

public class ServicioEdificio implements Servicio<Edificio,String>{

    @Override
    public void create(Edificio objeto) {
        if (validarDB(objeto)) {
            DaoEdificio daoEdificio = new DaoEdificio();
            daoEdificio.create(objeto);
        }
    }

    @Override
    public Edificio read(String identificador) {
        if (validarDB(identificador)) {
            DaoEdificio daoEdificio = new DaoEdificio();
            return daoEdificio.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Edificio objeto) {
        if (validarDB(objeto)) {
            DaoEdificio daoEdificio = new DaoEdificio();
            daoEdificio.update(objeto);
        }
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            DaoEdificio daoEdificio = new DaoEdificio();
            daoEdificio.delete(identificador);
        }
    }

    private Boolean validarDB(Edificio edificio){
        DaoEdificio daoEdificio = new DaoEdificio();
        if (daoEdificio.read(edificio.getCod_edificio()) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
        }
        return true;
    }

    private Boolean validarDB(String edificio){
        DaoEdificio daoEdificio = new DaoEdificio();
        if (daoEdificio.read(edificio) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
        }
        return true;
    }
    
}
