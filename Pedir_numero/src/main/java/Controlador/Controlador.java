package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void procesarNumero() {
        int numero = vista.pedirNumero();
        modelo.setNumero(numero);
        int digitos = modelo.contarDigitos();
        vista.mostrarResultado(digitos);
    }
}
