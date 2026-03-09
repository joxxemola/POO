package pruebas;

import modelo.Estudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {

    @Test
    void debeCalcularDefinitivaCorrectamente() {
        Estudiante e = new Estudiante(22000, "Ana", 4.0, 3.0);
        assertEquals(3.6, e.calcularDefinitiva(), 0.01);
    }

    @Test
    void debeAprobarSiDefinitivaMayorOIgualA35() {
        Estudiante e = new Estudiante(22001, "Luis", 5.0, 4.0);
        assertEquals("SI APRUEBA", e.obtenerEstado());
    }

    @Test
    void noDebeAprobarSiDefinitivaMenorA35() {
        Estudiante e = new Estudiante(22002, "Pedro", 2.0, 3.0);
        assertEquals("NO APRUEBA", e.obtenerEstado());
    }

    @Test
    void noDebePermitirCodigoMenorOIgualA21000() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(21000, "Carlos", 4.0, 4.0);
        });
    }

    @Test
    void debeIncrementarCorrectamente() {
        Estudiante e = new Estudiante(22003, "Maria", 4.0, 4.0);
        e.incrementarDesarrollo(0.3);
        assertEquals(4.3, e.getNotaDesarrollo(), 0.01);
    }

    @Test
    void noDebeSuperarNotaMaximaCinco() {
        Estudiante e = new Estudiante(22004, "Laura", 4.9, 4.0);
        e.incrementarDesarrollo(0.5);
        assertEquals(5.0, e.getNotaDesarrollo(), 0.01);
    }
}