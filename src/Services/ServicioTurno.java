package Services;

import data.DaoTurno;
import data.models.Turno;

public class ServicioTurno implements Servicio<Turno, String> {
    DaoTurno daoTurno = new DaoTurno();

    @Override
    public void create(Turno objeto) {
        if (validarDB(objeto)) {
            daoTurno.create(objeto);
            System.out.println("Turno creado con éxito");
        }
    }

    @Override
    public Turno read(String identificador) {
        if (!validarDB(identificador)) {
            return daoTurno.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Turno objeto) {
        if (!validarDB(objeto)) {
            daoTurno.update(objeto);
            System.out.println("Turno actualizado con éxito");
        }
        System.out.println("No se pudo actualizar el turno");
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            daoTurno.delete(identificador);
            System.out.println("Turno eliminado con éxito");
        }
        System.out.println("No se pudo eliminar el turno");
    }

    private Boolean validarDB(Turno turno) {
        if (daoTurno.read(turno.getCod_turno()) != null) {
            System.out.println("El turno existe en la base de datos");
            return false;
        }
        return true;
    }

    private Boolean validarDB(String turno) {

        if (daoTurno.read(turno) != null) {
            System.out.println("El turno existe en la base de datos");
            return false;
        }
        return true;
    }

}
