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
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class VistaConsolaTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private VistaConsola vista;
    
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
    
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        vista = new VistaConsola();
    }
    
    private String getOutput() {
        return testOut.toString();
    }
    
    @Test
    public void testPedirNumeroSala() {
        // Simular entrada: "3\n"
        provideInput("3\n");
        
        int resultado = vista.pedirNumeroSala();
        
        assertEquals(3, resultado);
        assertTrue(getOutput().contains("Ingrese el número de sala (1-6):"));
    }
    
    @Test
    public void testPedirNumeroFacturas() {
        // Simular entrada: "5\n"
        provideInput("5\n");
        
        // Como ya usamos provideInput, necesitamos crear una nueva vista o reiniciar el scanner
        // Mejor hacemos un método separado
    }
    
    // Método auxiliar para probar pedirNumeroFacturas
    @Test
    public void testPedirNumeroFacturasConSala() {
        String input = "4\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        int resultado = vistaLocal.pedirNumeroFacturas(2);
        
        assertEquals(4, resultado);
        assertTrue(testOut.toString().contains("¿Cuántas facturas desea ingresar para la sala 2?"));
    }
    
    @Test
    public void testPedirDatosClienteConTarjeta() {
        // Simular entrada: "Juan Pérez\ns\n"
        String input = "Juan Pérez\ns\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        Cliente cliente = vistaLocal.pedirDatosCliente();
        
        assertNotNull(cliente);
        assertEquals("Juan Pérez", cliente.getNombre());
        assertTrue(cliente.isTieneTarjeta());
        
        String output = testOut.toString();
        assertTrue(output.contains("Nombre del comprador:"));
        assertTrue(output.contains("¿Tiene tarjeta de descuento? (s/n):"));
    }
    
    @Test
    public void testPedirDatosClienteSinTarjeta() {
        // Simular entrada: "María López\nn\n"
        String input = "María López\nn\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        Cliente cliente = vistaLocal.pedirDatosCliente();
        
        assertNotNull(cliente);
        assertEquals("María López", cliente.getNombre());
        assertFalse(cliente.isTieneTarjeta());
    }
    
    @Test
    public void testPedirDatosFactura() {
        // Simular entrada para factura
        String input = "Cine Colombia\n35 mm\n3\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        Cliente cliente = new Cliente("Carlos Ruiz", true);
        Factura factura = vistaLocal.pedirDatosFactura(cliente, 1);
        
        assertNotNull(factura);
        assertEquals(cliente, factura.getCliente());
        assertEquals("Cine Colombia", factura.getPromotora());
        assertEquals("35 mm", factura.getTipoFuncion());
        assertEquals(3, factura.getNumBoletas());
        
        String output = testOut.toString();
        assertTrue(output.contains("--- Factura #1 ---"));
        assertTrue(output.contains("Promotora:"));
        assertTrue(output.contains("Tipo de función:"));
        assertTrue(output.contains("Número de boletas:"));
    }
    
    @Test
    public void testPedirDatosFacturaRoyalFilms3D() {
        // Simular entrada para factura con Royal Films y 3D
        String input = "Royal Films\n3D\n2\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        Cliente cliente = new Cliente("Ana Pérez", false);
        Factura factura = vistaLocal.pedirDatosFactura(cliente, 2);
        
        assertNotNull(factura);
        assertEquals(cliente, factura.getCliente());
        assertEquals("Royal Films", factura.getPromotora());
        assertEquals("3D", factura.getTipoFuncion());
        assertEquals(2, factura.getNumBoletas());
    }
    
    @Test
    public void testMostrarMensaje() {
        provideInput(""); // Entrada vacía, no importa
        vista.mostrarMensaje("Mensaje de prueba");
        
        assertTrue(getOutput().contains("Mensaje de prueba"));
    }
    
    @Test
    public void testMostrarReporte() {
        provideInput(""); // No necesitamos entrada para este test
        
        // Crear datos de prueba
        SalaCine sala = new SalaCine(3);
        Cliente c1 = new Cliente("Laura", true);
        Cliente c2 = new Cliente("Pedro", false);
        
        Factura f1 = new Factura(c1, "Cine Colombia", "3D", 2);
        Factura f2 = new Factura(c2, "Royal Films", "35 mm", 3);
        
        sala.agregarFactura(f1);
        sala.agregarFactura(f2);
        
        // Ejecutar el método a probar
        vista.mostrarReporte(sala, 3);
        
        // Verificar la salida
        String output = getOutput();
        assertTrue(output.contains("REPORTE DE VENTAS - SALA 3"));
        assertTrue(output.contains("DETALLE DE FACTURAS"));
        assertTrue(output.contains("Cliente: Laura"));
        assertTrue(output.contains("Promotora: Cine Colombia"));
        assertTrue(output.contains("Tipo función: 3D"));
        assertTrue(output.contains("Número de boletas: 2"));
        assertTrue(output.contains("Tarjeta descuento: Sí"));
        assertTrue(output.contains("Cliente: Pedro"));
        assertTrue(output.contains("Promotora: Royal Films"));
        assertTrue(output.contains("Tipo función: 35 mm"));
        assertTrue(output.contains("Número de boletas: 3"));
        assertTrue(output.contains("Tarjeta descuento: No"));
        assertTrue(output.contains("Dinero recibido en sala:"));
        assertTrue(output.contains("Total Cine Colombia:"));
        assertTrue(output.contains("Total Royal Films:"));
        assertTrue(output.contains("Tipo de función más vendida:"));
    }
    
    @Test
    public void testMostrarReporteConUnaFactura() {
        provideInput(""); // No necesitamos entrada
        
        SalaCine sala = new SalaCine(1);
        Cliente c = new Cliente("Carlos", false);
        Factura f = new Factura(c, "Cine Colombia", "35 mm", 4);
        sala.agregarFactura(f);
        
        vista.mostrarReporte(sala, 1);
        
        String output = getOutput();
        assertTrue(output.contains("SALA 1"));
        assertTrue(output.contains("Cliente: Carlos"));
        assertTrue(output.contains("Número de boletas: 4"));
        assertTrue(output.contains("Tarjeta descuento: No"));
    }
    
    @Test
    public void testMostrarReporteSalaSinFacturas() {
        provideInput(""); // No necesitamos entrada
        
        SalaCine sala = new SalaCine(5);
        
        vista.mostrarReporte(sala, 5);
        
        String output = getOutput();
        assertTrue(output.contains("SALA 5"));
        assertTrue(output.contains("DETALLE DE FACTURAS"));
        // No debe mostrar detalles de clientes
        assertFalse(output.contains("Cliente:"));
        // Pero debe mostrar los totales
        assertTrue(output.contains("Dinero recibido en sala: $0.00"));
        assertTrue(output.contains("Total Cine Colombia: $0.00"));
        assertTrue(output.contains("Total Royal Films: $0.00"));
        assertTrue(output.contains("Tipo de función más vendida: 35 mm"));
    }
    
    @Test
    public void testCerrar() {
        provideInput(""); // No necesitamos entrada
        
        // No hay mucho que probar aquí, solo que no lance excepción
        assertDoesNotThrow(() -> vista.cerrar());
    }
    
    @Test
    public void testFlujoCompletoInteraccion() {
        // Simular una interacción completa con el usuario
        String input = "3\n" +           // número de sala
                       "2\n" +           // número de facturas
                       "Ana\n" +         // nombre cliente 1
                       "s\n" +           // tarjeta sí
                       "Cine Colombia\n" + // promotora 1
                       "3D\n" +          // tipo función 1
                       "3\n" +           // boletas 1
                       "Luis\n" +        // nombre cliente 2
                       "n\n" +           // tarjeta no
                       "Royal Films\n" + // promotora 2
                       "35 mm\n" +       // tipo función 2
                       "2\n";            // boletas 2
        
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        VistaConsola vistaLocal = new VistaConsola();
        
        // Probar cada método secuencialmente
        int numSala = vistaLocal.pedirNumeroSala();
        assertEquals(3, numSala);
        
        int numFacturas = vistaLocal.pedirNumeroFacturas(numSala);
        assertEquals(2, numFacturas);
        
        Cliente c1 = vistaLocal.pedirDatosCliente();
        assertEquals("Ana", c1.getNombre());
        assertTrue(c1.isTieneTarjeta());
        
        Factura f1 = vistaLocal.pedirDatosFactura(c1, 1);
        assertEquals("Cine Colombia", f1.getPromotora());
        assertEquals("3D", f1.getTipoFuncion());
        assertEquals(3, f1.getNumBoletas());
        
        Cliente c2 = vistaLocal.pedirDatosCliente();
        assertEquals("Luis", c2.getNombre());
        assertFalse(c2.isTieneTarjeta());
        
        Factura f2 = vistaLocal.pedirDatosFactura(c2, 2);
        assertEquals("Royal Films", f2.getPromotora());
        assertEquals("35 mm", f2.getTipoFuncion());
        assertEquals(2, f2.getNumBoletas());
        
        // Verificar cálculos
        assertEquals(3 * 9500 * 0.9, f1.calcularTotal(), 0.01); // 25650
        assertEquals(2 * 6500, f2.calcularTotal(), 0.01);       // 13000
        
        String output = testOut.toString();
        assertTrue(output.contains("Ingrese el número de sala"));
        assertTrue(output.contains("¿Cuántas facturas desea ingresar para la sala 3?"));
    }
}