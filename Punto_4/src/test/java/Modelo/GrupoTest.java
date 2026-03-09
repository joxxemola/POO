package Modelo;

import modelo.Grupo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {

    @Test
    public void testCalcularPorcentajePerdida() {
        Grupo g = new Grupo(1, "Juan", 3.5, 20, 15);
        assertEquals(25.0, g.calcularPorcentajePerdida(), 0.01);
    }

    @Test
    public void testGetters() {
        Grupo g = new Grupo(2, "Ana", 4.0, 10, 8);

        assertEquals(2, g.getCodGrupo());
        assertEquals("Ana", g.getProfesor());
        assertEquals(4.0, g.getPromGrupo());
        assertEquals(10, g.getNumEstudiantes());
        assertEquals(8, g.getGanaron());
    }

    @Test
    public void testSetProfesor() {
        Grupo g = new Grupo(3, "Luis", 3.8, 15, 12);
        g.setProfesor("Carlos");
        assertEquals("Carlos", g.getProfesor());
    }

    @Test
    public void testValidacionCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Grupo(70, "Juan", 3.5, 10, 5);
        });
    }
}