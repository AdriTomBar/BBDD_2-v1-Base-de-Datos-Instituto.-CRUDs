package data.models;

public class Aula {
    private String num_aula;
    private String cod_edificio;

    public Aula(String num_aula, String cod_edificio) {
        this.num_aula = num_aula;
        this.cod_edificio = cod_edificio;
    }
    
    @Override
    public String toString() {
        return "Aula [cod_edificio=" + cod_edificio + ", num_aula=" + num_aula + "]";
    }
}
