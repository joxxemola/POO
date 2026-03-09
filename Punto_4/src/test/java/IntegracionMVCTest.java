

import modelo.Materia;
import controlador.ControladorMateria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegracionMVCTest {

    @Test
    public void testFlujoCompleto() {

        Materia materia = new Materia("POO1", "Programacion", 1);
        ControladorMateria controlador = new ControladorMateria(materia);

        controlador.crearGrupo(1, "Andres", 3.9, 10, 7);

        String resultadoBusqueda = controlador.buscarGrupo(1);
        double porcentaje = controlador.calcularPorcentajePerdida(1);

        assertTrue(resultadoBusqueda.contains("Andres"));
        assertEquals(30.0, porcentaje, 0.01);
    }
}