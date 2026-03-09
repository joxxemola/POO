import modelo.Cliente;
import modelo.Factura;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaTest {
    
    @Test
    public void testConstructorFactura() {
        Cliente cliente = new Cliente("Juan", true);
        Factura factura = new Factura(cliente, "Cine Colombia", "35 mm", 3);
        assertNotNull(factura);
        assertEquals(cliente, factura.getCliente());
        assertEquals("Cine Colombia", factura.getPromotora());
        assertEquals("35 mm", factura.getTipoFuncion());
        assertEquals(3, factura.getNumBoletas());
    }
    
    @Test
    public void testGetValorUnitarioCineColombia35mm() {
        Cliente cliente = new Cliente("Ana", false);
        Factura factura = new Factura(cliente, "Cine Colombia", "35 mm", 1);
        assertEquals(8000, factura.getValorUnitario(), 0.01);
    }
    
    @Test
    public void testGetValorUnitarioCineColombia3D() {
        Cliente cliente = new Cliente("Ana", false);
        Factura factura = new Factura(cliente, "Cine Colombia", "3D", 1);
        assertEquals(9500, factura.getValorUnitario(), 0.01);
    }
    
    @Test
    public void testGetValorUnitarioRoyalFilms35mm() {
        Cliente cliente = new Cliente("Carlos", false);
        Factura factura = new Factura(cliente, "Royal Films", "35 mm", 1);
        assertEquals(6500, factura.getValorUnitario(), 0.01);
    }
    
    @Test
    public void testGetValorUnitarioRoyalFilms3D() {
        Cliente cliente = new Cliente("Carlos", false);
        Factura factura = new Factura(cliente, "Royal Films", "3D", 1);
        assertEquals(8500, factura.getValorUnitario(), 0.01);
    }
    
    @Test
    public void testCalcularTotalSinTarjeta() {
        Cliente cliente = new Cliente("María", false);
        Factura factura = new Factura(cliente, "Cine Colombia", "35 mm", 2);
        assertEquals(16000, factura.calcularTotal(), 0.01);
    }
    
    @Test
    public void testCalcularTotalConTarjeta() {
        Cliente cliente = new Cliente("María", true);
        Factura factura = new Factura(cliente, "Cine Colombia", "35 mm", 2);
        assertEquals(14400, factura.calcularTotal(), 0.01);
    }
}