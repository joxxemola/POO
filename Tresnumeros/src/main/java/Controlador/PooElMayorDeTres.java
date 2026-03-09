/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

/**
 *
 * @author emgallego
 */

import Modelo.NumeroModelo;
import Vista.Vista;

public class PooElMayorDeTres {
    public static void main(String[] args) {
        //instanciar
        NumeroModelo modelo = new  NumeroModelo();
        Vista vista = new Vista();
       
        int n1 = vista.pedirNumero("primer");
        int n2 = vista.pedirNumero("segundo");
        int n3 = vista.pedirNumero("tercero");
       
        //ejecutamos  la logica del negocio.
       
        modelo.setNumero1(n1);
        modelo.setNumero2(n2);
        modelo.setNumero3(n3);
       
        int resultado = modelo.calcularMayor();
        String repetidos = modelo.numerosRepetidos();

        vista.mostrarResultado(resultado);
        vista.mostrarRepetidos(repetidos);
    }
}
