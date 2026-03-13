/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Usuario
 */

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

    public static void main(String[] args) {

        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        int nota = vista.pedirNota();
        modelo.setNota(nota);

        String resultado = modelo.evaluarNota();
        vista.mostrarResultado(resultado);
    }
}


