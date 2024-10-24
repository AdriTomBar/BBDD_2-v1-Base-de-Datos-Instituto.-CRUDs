package Services;
import data.DaoTurno;
import data.models.Turno;

public class ServicioTurno implements Servicio<Turno,String>{

    @Override
    public void create(Turno objeto) {
        if (validarDB(objeto)) {
            DaoTurno daoTurno = new DaoTurno();
            daoTurno.create(objeto);
        }
    }

    @Override
    public Turno read(String identificador) {
        if (validarDB(identificador)) {
            DaoTurno daoTurno = new DaoTurno();
            return daoTurno.read(identificador);
        }
        return null;
    }

    @Override
    public void update(Turno objeto) {
        if (validarDB(objeto)) {
            DaoTurno daoTurno = new DaoTurno();
            daoTurno.update(objeto);
        }
    }

    @Override
    public void delete(String identificador) {
        if (validarDB(identificador)) {
            DaoTurno daoTurno = new DaoTurno();
            daoTurno.delete(identificador);
        }
    }

    private Boolean validarDB(Turno turno){
        DaoTurno daoTurno = new DaoTurno();
        if (daoTurno.read(turno.getCod_turno()) != null) { 
            System.out.println("El turno ya existe en la base de datos");
        }
        return true;
    }

    private Boolean validarDB(String turno){
        DaoTurno daoTurno = new DaoTurno();
        if (daoTurno.read(turno) != null) { 
            System.out.println("El turno ya existe en la base de datos");
        }
        return true;
    }


    
}
