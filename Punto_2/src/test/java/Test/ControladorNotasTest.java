package Test;

import modelo.ModeloNotas;
import vista.VistaNotas;
import controlador.ControladorNotas;
import org.junit.jupiter.api.Test;

public class ControladorNotasTest {

    @Test
    public void pruebaEjecucionControlador() {

        // Creamos datos simulados
        double[] notas = {3.5, 2.0, 4.0, 1.0, 3.2};

        ModeloNotas modelo = new ModeloNotas(notas);
        VistaNotas vista = new VistaNotas();
        ControladorNotas controlador = new ControladorNotas(modelo, vista);

        // Ejecutamos método principal del controlador
        controlador.iniciar();

        // Si no lanza errores, la prueba pasa
    }
}