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
		if ( validarDepartamento(objeto) && validarDB(objeto) == true) {
			daoDepartamento.create(objeto);
			
		} else {
			System.out.println("No se pudo crear el departamento");
		}
	}

	@Override
	public Departamento read(String identificador) {
		if (identificador.length() > 0 && (validarDB(identificador)==false)) {
			return daoDepartamento.read(identificador);
		}
		return null;
	}

	@Override
	public void update(Departamento objeto) {
		if (validarDepartamento(objeto) && validarDB(objeto) == false) {
			daoDepartamento.update(objeto);
		} else {
			System.out.println("No se pudo actualizar el departamento");
		}
	}

	@Override
	public void delete(String identificador) {
		if (identificador.length() > 0 && (validarDB(identificador)==false)) {
			daoDepartamento.delete(identificador);
		} else {
			System.out.println("No se pudo eliminar el departamento");
		}
	}

	private boolean validarDepartamento(Departamento departamento) {
		if (departamento.getCod_departamento().length() < 1) {
			throw new IllegalArgumentException("El código del departamento debe tener al menos 1 caracter");
		}
		return true;
	}

	

	private boolean validarDB(Departamento departamento) {
		String cod_departamento = departamento.getCod_departamento();
		if (daoDepartamento.read(cod_departamento) != null) {
			System.out.println("El departamento ya existe");
			return false;
		}
		return true;
	}

	private boolean validarDB(String cod_departamento) {
		if (cod_departamento != null) {
			return false;
		}
		return true;
	}

}
