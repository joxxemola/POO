/**
 *
 * @author Jose David Molano Perdomo
 */

package Modelo;

import modelo.Estudiante;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {
    private Estudiante estudiante1;
    private Estudiante estudiante2;
    private Estudiante estudiante3;
    
    @BeforeEach
    public void setUp() {
        estudiante1 = new Estudiante(21001, "Juan Pérez", 4.0, 3.5);
        estudiante2 = new Estudiante(21002, "María Gómez", 2.0, 2.5);
        estudiante3 = new Estudiante(21003, "Carlos López", 5.0, 5.0);
    }
    
    @Test
    @DisplayName("Test 1: Verificar constructor y getters")
    public void testConstructorYGetters() {
        assertEquals(21001, estudiante1.getCodigo(), "El código debería ser 21001");
        assertEquals("Juan Pérez", estudiante1.getNombre(), "El nombre debería ser Juan Pérez");
        assertEquals(4.0, estudiante1.getNotaDesarrollo(), 0.001, "Nota Desarrollo debería ser 4.0");
        assertEquals(3.5, estudiante1.getNotaMatematica(), 0.001, "Nota Matemática debería ser 3.5");
    }
    
    @Test
    @DisplayName("Test 2: Calcular definitiva con notas mixtas")
    public void testCalcularDefinitivaMixta() {
        double definitiva = estudiante1.calcularDefinitiva();
        // 4.0*0.55 + 3.5*0.45 = 2.2 + 1.575 = 3.775
        assertEquals(3.775, definitiva, 0.001, "La definitiva debería ser 3.775");
    }
    
    @Test
    @DisplayName("Test 3: Calcular definitiva con notas bajas")
    public void testCalcularDefinitivaBajas() {
        double definitiva = estudiante2.calcularDefinitiva();
        // 2.0*0.55 + 2.5*0.45 = 1.1 + 1.125 = 2.225
        assertEquals(2.225, definitiva, 0.001, "La definitiva debería ser 2.225");
    }
    
    @Test
    @DisplayName("Test 4: Calcular definitiva con notas máximas")
    public void testCalcularDefinitivaMaximas() {
        double definitiva = estudiante3.calcularDefinitiva();
        // 5.0*0.55 + 5.0*0.45 = 2.75 + 2.25 = 5.0
        assertEquals(5.0, definitiva, 0.001, "La definitiva debería ser 5.0");
    }
    
    @Test
    @DisplayName("Test 5: Verificar aprobación - Aprueba")
    public void testVerificarAprobacionAprueba() {
        Estudiante e = new Estudiante(21004, "Ana Torres", 4.0, 4.0);
        String resultado = e.verificarAprobacion();
        assertEquals("SI APRUEBA", resultado, "Debería aprobar con nota 4.0");
    }
    
    @Test
    @DisplayName("Test 6: Verificar aprobación - No aprueba")
    public void testVerificarAprobacionNoAprueba() {
        Estudiante e = new Estudiante(21005, "Pedro Sánchez", 2.0, 2.0);
        String resultado = e.verificarAprobacion();
        assertEquals("NO APRUEBA", resultado, "No debería aprobar con nota 2.0");
    }
    
    @Test
    @DisplayName("Test 7: Verificar aprobación - Justo en el límite (3.5)")
    public void testVerificarAprobacionLimite() {
        Estudiante e = new Estudiante(21006, "Laura Martínez", 3.5, 3.5);
        // 3.5*0.55 + 3.5*0.45 = 1.925 + 1.575 = 3.5
        String resultado = e.verificarAprobacion();
        assertEquals("SI APRUEBA", resultado, "Con 3.5 exactos debería aprobar");
    }
    
    @Test
    @DisplayName("Test 8: Incrementar nota Desarrollo sin pasar límite")
    public void testIncrementarNotaDesarrolloDentroLimite() {
        estudiante1.incrementarNotaDesarrollo(0.3);
        assertEquals(4.3, estudiante1.getNotaDesarrollo(), 0.001, 
                    "La nota debería incrementarse a 4.3");
    }
    
    @Test
    @DisplayName("Test 9: Incrementar nota Desarrollo pasando límite")
    public void testIncrementarNotaDesarrolloSuperaLimite() {
        Estudiante e = new Estudiante(21007, "Roberto Díaz", 4.8, 3.0);
        e.incrementarNotaDesarrollo(0.3);
        assertEquals(5.0, e.getNotaDesarrollo(), 0.001, 
                    "La nota debería quedar en 5.0 (máximo)");
    }
    
    @Test
    @DisplayName("Test 10: Incrementar nota Desarrollo desde nota máxima")
    public void testIncrementarNotaDesarrolloDesdeMaximo() {
        Estudiante e = new Estudiante(21008, "Sofía Ruiz", 5.0, 4.0);
        e.incrementarNotaDesarrollo(0.1);
        assertEquals(5.0, e.getNotaDesarrollo(), 0.001, 
                    "La nota debería mantenerse en 5.0");
    }
    
    @Test
    @DisplayName("Test 11: Modificar nota Desarrollo válida")
    public void testModificarNotaDesarrolloValida() {
        estudiante1.modificarNotaDesarrollo(4.7);
        assertEquals(4.7, estudiante1.getNotaDesarrollo(), 0.001, 
                    "La nota debería actualizarse a 4.7");
    }
    
    @Test
    @DisplayName("Test 12: Modificar nota Matemática válida")
    public void testModificarNotaMatematicaValida() {
        estudiante1.modificarNotaMatematica(4.2);
        assertEquals(4.2, estudiante1.getNotaMatematica(), 0.001, 
                    "La nota debería actualizarse a 4.2");
    }
    
    @Test
    @DisplayName("Test 13: Modificar nota Desarrollo inválida (mayor a 5.0)")
    public void testModificarNotaDesarrolloInvalidaMayor() {
        double notaOriginal = estudiante1.getNotaDesarrollo();
        estudiante1.modificarNotaDesarrollo(5.5);
        assertEquals(notaOriginal, estudiante1.getNotaDesarrollo(), 0.001, 
                    "La nota no debería cambiar si es inválida");
    }
    
    @Test
    @DisplayName("Test 14: Modificar nota Desarrollo inválida (menor a 0.0)")
    public void testModificarNotaDesarrolloInvalidaMenor() {
        double notaOriginal = estudiante1.getNotaDesarrollo();
        estudiante1.modificarNotaDesarrollo(-1.0);
        assertEquals(notaOriginal, estudiante1.getNotaDesarrollo(), 0.001, 
                    "La nota no debería cambiar si es inválida");
    }
    
    @Test
    @DisplayName("Test 15: Verificar que calcularDefinitiva usa las notas actualizadas")
    public void testCalcularDefinitivaConNotasActualizadas() {
        estudiante1.modificarNotaDesarrollo(5.0);
        estudiante1.modificarNotaMatematica(5.0);
        
        double definitiva = estudiante1.calcularDefinitiva();
        assertEquals(5.0, definitiva, 0.001, 
                    "La definitiva debería ser 5.0 después de actualizar notas");
    }
}