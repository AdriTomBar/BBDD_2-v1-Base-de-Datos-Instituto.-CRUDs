package data.models;

import java.sql.Date;

public class Alumno {
    @NotNull(message = "El NRE no puede ser nulo")
    @size(min = 7, max = 7, message = "El NRE debe tener entre 1 y 10 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "El NRE debe ser un número")
    private String nre;
    @NotNull(message = "El nombre no puede ser nulo")
    @size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El nombre no puede contener números")
    private String nombre;
    @NotNull(message = "El primer apellido no puede ser nulo")
    @size(min = 1, max = 50, message = "El primer apellido debe tener entre 1 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El apellido no puede contener números")
    private String apellido1;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El apellido no puede contener números")
    @size(min = 1, max = 50, message = "El segundo apellido debe tener entre 1 y 50 caracteres")
    private String apellido2;
    @NotNull(message = "El DNI no puede ser nulo")
    @size(min = 9, max = 9, message = "El DNI debe tener 9 caracteres")
    @Pattern(regexp = "^[0-9]{8}[A-Z]", message = "El DNI debe ser un número seguido de una letra mayúscula")
    private String dni;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El tipo de vía no puede contener números")
    @NotNull(message = "El tipo de vía no puede ser nulo")
    private String tipo_via;
    @NotNull(message = "El nombre de la vía no puede ser nulo")
    @size(min = 1, max = 50, message = "El nombre de la vía debe tener entre 1 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El nombre de la vía no puede contener números")
    private String nombre_via;
    @NotNull(message = "El número no puede ser nulo")
    @size(min = 1, max = 10, message = "El número debe tener entre 1 y 10 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "El número debe ser un número")
    private String numero;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "La escalera no puede contener números")
    @Null
    private String escalera;
    @Null
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El piso no puede contener números")
    private String piso;
    @Null
    @Pattern(regexp = "^[a-zA-Z]*$", message = "La puerta no puede contener números")
    private String puerta;
    @NotNull(message = "El código postal no puede ser nulo")
    @size(min = 5, max = 5, message = "El código postal debe tener 5 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "El código postal debe ser un número")
    private String cp;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El país no puede contener números")
    @NotNull(message = "El país no puede ser nulo")
    private String pais;
    @Null
    @size(min = 9, max = 9, message = "El teléfono fijo debe tener 9 caracteres")
    private String tlfn_fijo;
    @NotNull(message = "El teléfono móvil no puede ser nulo")
    @size(min = 9, max = 9, message = "El teléfono móvil debe tener 9 caracteres")
    private String tlfn_movil;
    @NotNull(message = "El email no puede ser nulo")
    @size(min = 1, max = 100, message = "El email debe tener entre 1 y 100 caracteres")
    private String email;
    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @size(min = 10, max = 10, message = "La fecha de nacimiento debe tener 10 caracteres")
    @Pattern(regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$", message = "La fecha de nacimiento debe tener el formato dd/mm/yyyy")
    private String fecha_nac;
    @NotNull(message = "El tutor no puede ser nulo")
    @size(min = 1, max = 50, message = "El tutor debe tener entre 1 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El tutor no puede contener números")
    private String tutor;
    
    public Alumno(String nre, String nombre, String apellido1, String apellido2, String dni, String tipo_via,
            String nombre_via, String numero, String escalera, String piso, String puerta, String cp, String pais,
            String tlfn_fijo, String tlfn_movil, String email, String fecha_nac, String tutor) {
        this.nre = nre;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.tipo_via = tipo_via;
        this.nombre_via = nombre_via;
        this.numero = numero;
        this.escalera = escalera;
        this.piso = piso;
        this.puerta = puerta;
        this.cp = cp;
        this.pais = pais;
        this.tlfn_fijo = tlfn_fijo;
        this.tlfn_movil = tlfn_movil;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.tutor = tutor;
    }

    public Alumno() {
        //TODO Auto-generated constructor stub
    }


    public String getNre() {
        return nre;
    }

    public void setNre(String nre) {
        this.nre = nre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipo_via() {
        return tipo_via;
    }

    public void setTipo_via(String tipo_via) {
        this.tipo_via = tipo_via;
    }

    public String getNombre_via() {
        return nombre_via;
    }

    public void setNombre_via(String nombre_via) {
        this.nombre_via = nombre_via;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEscalera() {
        return escalera;
    }

    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTlfn_fijo() {
        return tlfn_fijo;
    }

    public void setTlfn_fijo(String tlfn_fijo) {
        this.tlfn_fijo = tlfn_fijo;
    }

    public String getTlfn_movil() {
        return tlfn_movil;
    }

    public void setTlfn_movil(String tlfn_movil) {
        this.tlfn_movil = tlfn_movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String gettutor() {
        return tutor;
    }

    public void settutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString(){
        return "Alumno [Nre=" + nre + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", dni=" + dni + ", tipo_via=" + tipo_via + ", nombre_via=" + nombre_via + ", numero=" + numero
                + ", escalera=" + escalera + ", piso=" + piso + ", puerta=" + puerta + ", cp=" + cp + ", pais=" + pais
                + ", tlfn_fijo=" + tlfn_fijo + ", tlfn_movil=" + tlfn_movil + ", email=" + email + ", fecha_nac="
                + fecha_nac + ", tutor=" + tutor + "]";
    }

	

}
