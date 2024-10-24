package Services;

import data.DaoEdificio;
import data.models.Edificio;

public class ServicioEdificio implements Servicio<Edificio,String>{

    private DaoEdificio daoEdificio = new DaoEdificio();

    @Override
    public void create(Edificio objeto) {
        if (validarDB(objeto)) {
            daoEdificio.create(objeto);
        }
    }

    @Override
    public Edificio read(String identificador) {
        if (validarDB(identificador)) {
            return daoEdificio.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Edificio objeto) {
        if (validarDB(objeto)) {
            daoEdificio.update(objeto);
        }
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            daoEdificio.delete(identificador);
        }
    }

    private Boolean validarDB(Edificio edificio){
        if (daoEdificio.read(edificio.getCod_edificio()) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
        }
        return true;
    }

    private Boolean validarDB(String edificio){
        if (daoEdificio.read(edificio) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
        }
        return true;
    }
    
}
