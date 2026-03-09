package Controlador;

import modelo.Materia;
import controlador.ControladorMateria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorMateriaTest {

    @Test
    public void testCrearYBuscarGrupo() {

        Materia m = new Materia("POO1", "Programacion", 1);
        ControladorMateria c = new ControladorMateria(m);

        c.crearGrupo(1, "Laura", 4.0, 20, 18);

        assertTrue(c.buscarGrupo(1).contains("Laura"));
    }

    @Test
    public void testCalcularPorcentajePerdida() {

        Materia m = new Materia("POO1", "Programacion", 1);
        ControladorMateria c = new ControladorMateria(m);

        c.crearGrupo(1, "Laura", 4.0, 20, 15);

        assertEquals(25.0, c.calcularPorcentajePerdida(1), 0.01);
    }

    @Test
    public void testObtenerMayorPromedio() {

        Materia m = new Materia("POO1", "Programacion", 2);
        ControladorMateria c = new ControladorMateria(m);

        c.crearGrupo(1, "A", 3.5, 20, 15);
        c.crearGrupo(2, "B", 4.7, 20, 19);

        assertEquals(4.7, c.obtenerMayorPromedio(), 0.01);
    }
}