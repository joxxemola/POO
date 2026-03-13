package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {
    public static void main(String[] args) {
        Vista vista = new Vista();

        Modelo f1 = new Modelo(
            vista.pedirNumero("Día 1: "),
            vista.pedirNumero("Mes 1: "),
            vista.pedirNumero("Año 1: ")
        );

        Modelo f2 = new Modelo(
            vista.pedirNumero("Día 2: "),
            vista.pedirNumero("Mes 2: "),
            vista.pedirNumero("Año 2: ")
        );

        int dias = Math.abs(f1.convertirADias() - f2.convertirADias());
        vista.mostrarResultado(dias);
    }
}
