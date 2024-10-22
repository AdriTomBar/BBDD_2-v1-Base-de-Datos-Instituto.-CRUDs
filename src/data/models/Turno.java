package data.models;

public class Turno {
    private String cod_turno;
    private String horario;

    public Turno(String cod_turno, String horario) {
        this.cod_turno = cod_turno;
        this.horario = horario;
    }

    public String getCod_turno() {
        return cod_turno;
    }
    public String getHorario() {
        return horario;
    }
    public void setCod_turno(String cod_turno) {
        this.cod_turno = cod_turno;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turno [cod_turno=" + cod_turno + ", horario=" + horario + "]";
    }
}
