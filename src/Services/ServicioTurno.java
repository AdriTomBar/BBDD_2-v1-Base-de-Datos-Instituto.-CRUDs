package Services;

import data.Dao;
import data.DaoTurno;
import data.models.Turno;

public class ServicioTurno implements Servicio<Turno,String>{

    @Override
    public void create(Turno objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Turno read(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void update(Turno objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Boolean validarDB(Turno turno){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evalidarDB'");
    }

    private Boolean validarDB(String turno){
        DaoTurno daoTurno = new DaoTurno();
        if (daoTurno.read(turno) != null) { 
            throw new IllegalArgumentException("El turno ya existe en la base de datos");
        }
    }


    
}
