package Services;

import data.DaoDepartamento;
import data.models.Departamento;

public class ServicioDepartamento implements Servicio<Departamento, String> {

	private DaoDepartamento daoDepartamento;
	
	public ServicioDepartamento(DaoDepartamento daoDepartamento) {
		this.daoDepartamento = daoDepartamento; 
	}
	
	@Override
	public void create(Departamento objeto) {
		// TODO Auto-generated method stub
		daoDepartamento.create(objeto);
	}

	@Override
	public Departamento read(String identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Departamento objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String identificador) {
		// TODO Auto-generated method stub
		
	}

}
