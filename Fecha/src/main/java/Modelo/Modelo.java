package Modelo;

public class Modelo {
    private int dia;
    private int mes;
    private int anio;

    public Modelo(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters y setters
    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int convertirADias() {
        return (anio * 360) + (mes * 30) + dia;
    }
}
