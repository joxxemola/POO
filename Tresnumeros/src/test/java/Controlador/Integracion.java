/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Usuario
 */
import Modelo.NumeroModelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    @Test

    public void testFlujocontroladorModelo(){
    
    NumeroModelo modelo= new NumeroModelo();
    //crear valores de prueba
    
    int n1= 10;
    int n2= 11;
    int n3= 12;
    
    modelo.setNumero1(n1);
    modelo.setNumero2(n2);
    modelo.setNumero3(n3);
    
    }
