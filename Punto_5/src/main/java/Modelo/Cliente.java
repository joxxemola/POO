package modelo;

public class Cliente {
    private String nombre;
    private boolean tieneTarjeta;

    public Cliente(String nombre, boolean tieneTarjeta) {
        this.nombre = nombre;
        this.tieneTarjeta = tieneTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isTieneTarjeta() {
        return tieneTarjeta;
    }
}