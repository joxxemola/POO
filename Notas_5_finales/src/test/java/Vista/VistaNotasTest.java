import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VistaNotasTest {

    @Test
    void testMostrarResultado() {
        VistaNotas vista = new VistaNotas();

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        vista.mostrarResultado(3);

        assertTrue(salida.toString().contains("3"));
    }
}
