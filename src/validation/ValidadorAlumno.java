package validation;


public class ValidadorAlumno implements Validador<Alumno> {

	@Override
	public String[] getErroresValidacion(Alumno model) {
		String[] listaErroresValidacion;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Alumno>> errores = validator.validate(model);

		listaErroresValidacion = new String[errores.size()];
		int i = 0;
		for (ConstraintViolation<Alumno> error : errores) {
			listaErroresValidacion[i++] = error.getMessage();
		}
		return listaErroresValidacion;
	}

}
