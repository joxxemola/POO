package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo nota = new Modelo(vista.pedirNota());

        vista.mostrarNota(nota.notaEnTexto());
    }
}
