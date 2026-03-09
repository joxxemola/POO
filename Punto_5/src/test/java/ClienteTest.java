import modelo.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    
    @Test
    public void testConstructorCliente() {
        Cliente cliente = new Cliente("Juan Pérez", true);
        assertNotNull(cliente);
        assertEquals("Juan Pérez", cliente.getNombre());
        assertTrue(cliente.isTieneTarjeta());
    }
    
    @Test
    public void testClienteSinTarjeta() {
        Cliente cliente = new Cliente("María López", false);
        assertFalse(cliente.isTieneTarjeta());
    }
    
    @Test
    public void testGetNombre() {
        Cliente cliente = new Cliente("Carlos Ruiz", true);
        assertEquals("Carlos Ruiz", cliente.getNombre());
    }
}