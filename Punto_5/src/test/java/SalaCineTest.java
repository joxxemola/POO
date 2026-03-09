import modelo.Cliente;
import modelo.Factura;
import modelo.SalaCine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaCineTest {
    
    private SalaCine sala;
    private Cliente cliente1;
    private Cliente cliente2;
    
    @BeforeEach
    public void setUp() {
        sala = new SalaCine(1);
        cliente1 = new Cliente("Juan", false);
        cliente2 = new Cliente("Ana", true);
    }
    
    @Test
    public void testConstructorSalaCine() {
        assertEquals(1, sala.getNumero());
        assertTrue(sala.getFacturas().isEmpty());
    }
    
    @Test
    public void testAgregarFactura() {
        Factura factura = new Factura(cliente1, "Cine Colombia", "35 mm", 2);
        sala.agregarFactura(factura);
        assertEquals(1, sala.getFacturas().size());
    }
    
    @Test
    public void testDineroRecibido() {
        Factura f1 = new Factura(cliente1, "Cine Colombia", "35 mm", 2); // 16000
        Factura f2 = new Factura(cliente2, "Royal Films", "3D", 3); // 3*8500*0.9 = 22950
        sala.agregarFactura(f1);
        sala.agregarFactura(f2);
        
        assertEquals(38950, sala.dineroRecibido(), 0.01);
    }
    
    @Test
    public void testFacturarPorPromotora() {
        Factura f1 = new Factura(cliente1, "Cine Colombia", "35 mm", 2); // 16000
        Factura f2 = new Factura(cliente2, "Royal Films", "3D", 3); // 22950
        sala.agregarFactura(f1);
        sala.agregarFactura(f2);
        
        assertEquals(16000, sala.facturarPorPromotora("Cine Colombia"), 0.01);
        assertEquals(22950, sala.facturarPorPromotora("Royal Films"), 0.01);
    }
    
    @Test
    public void testTipoFuncionMasVendida() {
        Factura f1 = new Factura(cliente1, "Cine Colombia", "35 mm", 2);
        Factura f2 = new Factura(cliente2, "Royal Films", "3D", 3);
        Factura f3 = new Factura(cliente1, "Cine Colombia", "3D", 1);
        sala.agregarFactura(f1);
        sala.agregarFactura(f2);
        sala.agregarFactura(f3);
        
        assertEquals("3D", sala.tipoFuncionMasVendida());
    }
}