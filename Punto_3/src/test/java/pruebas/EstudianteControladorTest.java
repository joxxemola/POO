package pruebas;

import controlador.EstudianteControlador;
import modelo.Estudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteControladorTest {

    @Test
    void debeAgregarEstudianteCorrectamente() {

        EstudianteControlador controlador = new EstudianteControlador();
        Estudiante e = new Estudiante(22010, "Ana", 4.0, 4.0);

        controlador.agregarEstudiante(e);

        // Verificamos comportamiento indirecto
        controlador.incrementarNotas(0.2);

        assertEquals(4.2, e.getNotaDesarrollo(), 0.01);
    }

    @Test
    void debeIncrementarTodosLosEstudiantes() {

        EstudianteControlador controlador = new EstudianteControlador();

        Estudiante e1 = new Estudiante(22011, "Luis", 4.0, 3.0);
        Estudiante e2 = new Estudiante(22012, "Maria", 4.5, 4.0);

        controlador.agregarEstudiante(e1);
        controlador.agregarEstudiante(e2);

        controlador.incrementarNotas(0.5);

        assertEquals(4.5, e1.getNotaDesarrollo(), 0.01);
        assertEquals(5.0, e2.getNotaDesarrollo(), 0.01);
    }

    @Test
    void debeEvaluarNotaLimiteCorrectamente() {

        Estudiante e = new Estudiante(22013, "Carlos", 5.0, 5.0);

        assertTrue(e.calcularDefinitiva() > 4.0);
        assertFalse(e.calcularDefinitiva() < 4.0);
    }
}