/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Contralor;

import Controlador.ControladorEmpresa;
import Modelo.Factura;
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
public class ControladorEmpresaIT {
    
    public ControladorEmpresaIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registrarVenta method, of class ControladorEmpresa.
     */
    @Test
    public void testRegistrarVenta() {
        System.out.println("registrarVenta");
        int sala = 0;
        String nombre = "";
        boolean tarjeta = false;
        String promotora = "";
        String tipo = "";
        int cantidad = 0;
        ControladorEmpresa instance = null;
        Factura expResult = null;
        Factura result = instance.registrarVenta(sala, nombre, tarjeta, promotora, tipo, cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalCineColombia method, of class ControladorEmpresa.
     */
    @Test
    public void testTotalCineColombia() {
        System.out.println("totalCineColombia");
        ControladorEmpresa instance = null;
        double expResult = 0.0;
        double result = instance.totalCineColombia();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalRoyalFilms method, of class ControladorEmpresa.
     */
    @Test
    public void testTotalRoyalFilms() {
        System.out.println("totalRoyalFilms");
        ControladorEmpresa instance = null;
        double expResult = 0.0;
        double result = instance.totalRoyalFilms();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tipoMasVendido method, of class ControladorEmpresa.
     */
    @Test
    public void testTipoMasVendido() {
        System.out.println("tipoMasVendido");
        ControladorEmpresa instance = null;
        String expResult = "";
        String result = instance.tipoMasVendido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
