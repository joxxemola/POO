import controlador.ControlVentas;
import modelo.Cliente;
import modelo.Factura;
import modelo.SalaCine;
import vista.VistaConsola;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ControlVentasTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    
    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    
    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    
    @Test
    public void testEjecutarConSalaValida() {
        // Simular entrada: sala 2, 1 factura
        String input = "2\n1\nJuan\ns\nCine Colombia\n35 mm\n3\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        
        VistaConsola vista = new VistaConsola();
        ControlVentas control = new ControlVentas(vista);
        
        // Ejecutar (no debe lanzar excepción)
        assertDoesNotThrow(() -> control.ejecutar());
        
        // Verificar que se mostró el reporte
        String output = testOut.toString();
        assertTrue(output.contains("REPORTE DE VENTAS - SALA 2"));
        assertTrue(output.contains("Cliente: Juan"));
        assertTrue(output.contains("Tarjeta descuento: Sí"));
    }
    
    @Test
    public void testEjecutarConSalaInvalida() {
        // Simular entrada: sala 7 (inválida)
        String input = "7\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        
        VistaConsola vista = new VistaConsola();
        ControlVentas control = new ControlVentas(vista);
        
        control.ejecutar();
        
        String output = testOut.toString();
        assertTrue(output.contains("Error: El número de sala debe ser entre 1 y 6"));
    }
    
    @Test
    public void testEjecutarConCeroFacturas() {
        // Simular entrada: sala 3, 0 facturas
        String input = "3\n0\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        
        VistaConsola vista = new VistaConsola();
        ControlVentas control = new ControlVentas(vista);
        
        control.ejecutar();
        
        String output = testOut.toString();
        assertTrue(output.contains("Debe ingresar al menos una factura"));
    }
}