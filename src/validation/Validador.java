package validation;

public interface Validador<T> {
	public String[] getErroresValidacion(T model);
}
