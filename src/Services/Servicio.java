package Services;

public interface Servicio <T, S>{
	void create(T objeto);
	T read(S identificador);
	void update(T objeto);
	void delete(S identificador);
}