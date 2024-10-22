package data;

public interface Dao <T, S> {
    public void create(T model);
    public T read(S id);
    public void update(T model);
    public void delete(S id);
}
