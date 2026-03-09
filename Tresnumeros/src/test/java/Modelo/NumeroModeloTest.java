/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class NumeroModeloTest {
    
    public NumeroModeloTest() {
    }
    
    @Test
    public void testcalcularMyaorSegundoEsMayor(){
        NumeroModelo modelo= new NumeroModelo(10,50,20);
        
        //Ejecutarlo
        
        int resultado= modelo.calcularMayor();
        
        // Vdrificacion
        assertEquals(50,resultado,"El resultado deberi ser 50");
    }

    @Test
    public void testXalcularTerceroMayor(){
        NumeroModelo modelo= new NumeroModelo();
        modelo.setNumero1(5);
        modelo.setNumero2(15);
        modelo.setNumero3(100);
        
        int resultado2= modelo.calcularMayor();
        assertEquals(100,resultado2);
        
    }
    @Test
    public void testnumerosRepetidos (){
        NumeroModelo modelo= new NumeroModelo(5,5,5);
        
        int resultado3= modelo.calcularMayor();
        assertEquals(5,resultado3);
       
    }
   
}
