package test.modelo;

import modelo.Materia;
import modelo.Grupo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MateriaTest {

    @Test
    public void testAgregarYBuscarGrupo() {
        Materia m = new Materia("POO1", "Programacion", 2);
        Grupo g1 = new Grupo(1, "Carlos", 4.2, 20, 18);

        m.agregarGrupo(g1);

        assertNotNull(m.buscarGrupo(1));
        assertNull(m.buscarGrupo(2));
    }

    @Test
    public void testObtenerMayorPromedio() {
        Materia m = new Materia("POO1", "Programacion", 2);

        Grupo g1 = new Grupo(1, "Carlos", 3.5, 20, 15);
        Grupo g2 = new Grupo(2, "Ana", 4.5, 18, 17);

        m.agregarGrupo(g1);
        m.agregarGrupo(g2);

        assertEquals(4.5, m.obtenerMayorPromedio(), 0.01);
    }

    @Test
    public void testCambiarProfesor() {
        Materia m = new Materia("POO1", "Programacion", 1);
        Grupo g = new Grupo(1, "Pedro", 3.8, 15, 10);

        m.agregarGrupo(g);
        m.cambiarProfesor(1, "Maria");

        assertEquals("Maria", m.buscarGrupo(1).getProfesor());
    }
}