package Test;

import vista.VistaNotas;
import org.junit.jupiter.api.Test;

public class VistaNotasTest {

    @Test
    public void pruebaMostrarResultado() {
        VistaNotas vista = new VistaNotas();

        vista.mostrarResultado(3);

        // Si no genera excepción, la prueba es correcta
    }
}