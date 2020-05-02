package com.enterprise.version1.tallerfinalandroid;

public class DtoRegistroCalificaciones {

    private String idUnico;
    private String matricula;
    private String nombre;
    private String calificacion1;
    private String calificacion2;
    private String calificacion3;
    private String total;

    public DtoRegistroCalificaciones(String idUnico, String matricula, String nombre, String calificacion1, String calificacion2, String calificacion3, String total) {
        this.idUnico = idUnico;
        this.matricula = matricula;
        this.nombre = nombre;
        this.calificacion1 = calificacion1;
        this.calificacion2 = calificacion2;
        this.calificacion3 = calificacion3;
        this.total = total;
    }

    public String getIdUnico() {
        return idUnico;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalificacion1() {
        return calificacion1;
    }

    public String getCalificacion2() {
        return calificacion2;
    }

    public String getCalificacion3() {
        return calificacion3;
    }

    public String getTotal() {
        return total;
    }
}
