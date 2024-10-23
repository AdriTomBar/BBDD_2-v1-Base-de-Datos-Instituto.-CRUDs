package data.models;

public class Aula {
    private String num_aula;
    private String cod_edificio;

    public Aula(String num_aula, String cod_edificio) {
        this.num_aula = num_aula;
        this.cod_edificio = cod_edificio;
    }
    
    public Aula() {
        //TODO Auto-generated constructor stub
    }

    public String getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(String num_aula) {
        this.num_aula = num_aula;
    }

    public String getCod_edificio() {
        return cod_edificio;
    }

    public void setCod_edificio(String cod_edificio) {
        this.cod_edificio = cod_edificio;
    }

    @Override
    public String toString() {
        return "Aula [cod_edificio=" + cod_edificio + ", num_aula=" + num_aula + "]";
    }
}
