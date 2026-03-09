package modelo;

public class Estudiante {

    private int codigo;
    private String nombre;
    private double notaDesarrollo;
    private double notaMatematica;

    public Estudiante(int codigo, String nombre, double notaDesarrollo, double notaMatematica) {

        if (codigo <= 21000) {
            throw new IllegalArgumentException("El código debe ser mayor a 21000");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.notaDesarrollo = notaDesarrollo;
        this.notaMatematica = notaMatematica;
    }

    public double calcularDefinitiva() {
        return (notaDesarrollo * 0.6) + (notaMatematica * 0.4);
    }

    public String obtenerEstado() {
        if (calcularDefinitiva() >= 3.5) {
            return "SI APRUEBA";
        } else {
            return "NO APRUEBA";
        }
    }

    public void incrementarDesarrollo(double incremento) {
        if (incremento >= 0.0 && incremento <= 0.5) {
            notaDesarrollo = Math.min(5.0, notaDesarrollo + incremento);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaDesarrollo() {
        return notaDesarrollo;
    }
}