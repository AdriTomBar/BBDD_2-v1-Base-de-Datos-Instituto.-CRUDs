package Services;

import data.DaoEdificio;
import data.models.Edificio;

public class ServicioEdificio implements Servicio<Edificio,String>{

    private DaoEdificio daoEdificio = new DaoEdificio();

    @Override
    public void create(Edificio objeto) {
        if (validarDB(objeto)) {
            daoEdificio.create(objeto);
            System.out.println("Edificio creado con éxito");
        }
    }

    @Override
    public Edificio read(String identificador) {
        if (!validarDB(identificador)) {
            return daoEdificio.read(identificador);
        }
        System.out.println("No se pudo leer el edificio");
        return null;
    }

    @Override
    public void update(Edificio objeto) {
        if (!validarDB(objeto)) {
            daoEdificio.update(objeto);
            System.out.println("Edificio actualizado con éxito");
        }
        System.out.println("No se pudo actualizar el edificio");
    }

    @Override
    public void delete(String identificador) {
        System.out.println("No se pudo eliminar el edificio debido a las restricciones de la base de datos de foreign key");
        /**if (!validarDB(identificador)) {
            daoEdificio.delete(identificador);
            System.out.println("Edificio eliminado con éxito");
        }
        System.out.println( "No se pudo eliminar el edificio");
        */
    }

    private Boolean validarDB(Edificio edificio){
        if (daoEdificio.read(edificio.getCod_edificio()) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
            return false;
        }
        return true;
    }

    private Boolean validarDB(String edificio){
        if (daoEdificio.read(edificio) != null) { 
            System.out.println("El edificio ya existe en la base de datos");
            return false;
        }
        return true;
    }
    
}
