/**
 *
 * @author Jose David Molano Perdomo
 */


package Modelo;

import modelo.Asignatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaTest {
    private Asignatura desarrollo;
    private Asignatura matematica;
    
    @BeforeEach
    public void setUp() {
        desarrollo = new Asignatura("Desarrollo", 55.0);
        matematica = new Asignatura("Matemática", 45.0);
    }
    
    @Test
    @DisplayName("Test 1: Verificar constructor y getters")
    public void testConstructorYGetters() {
        assertEquals("Desarrollo", desarrollo.getNombre(), "El nombre debería ser Desarrollo");
        assertEquals(55.0, desarrollo.getPorcentaje(), 0.001, "El porcentaje debería ser 55.0");
        
        assertEquals("Matemática", matematica.getNombre(), "El nombre debería ser Matemática");
        assertEquals(45.0, matematica.getPorcentaje(), 0.001, "El porcentaje debería ser 45.0");
    }
    
    @Test
    @DisplayName("Test 2: Calcular ponderación con nota normal")
    public void testCalcularPonderacionNotaNormal() {
        double resultado = desarrollo.calcularPonderacion(4.0);
        // 4.0 * 0.55 = 2.2
        assertEquals(2.2, resultado, 0.001, "La ponderación de 4.0 en Desarrollo debería ser 2.2");
    }
    
    @Test
    @DisplayName("Test 3: Calcular ponderación con nota máxima")
    public void testCalcularPonderacionNotaMaxima() {
        double resultado = matematica.calcularPonderacion(5.0);
        // 5.0 * 0.45 = 2.25
        assertEquals(2.25, resultado, 0.001, "La ponderación de 5.0 en Matemática debería ser 2.25");
    }
    
    @Test
    @DisplayName("Test 4: Calcular ponderación con nota mínima")
    public void testCalcularPonderacionNotaMinima() {
        double resultado = desarrollo.calcularPonderacion(0.0);
        assertEquals(0.0, resultado, 0.001, "La ponderación de 0.0 debería ser 0.0");
    }
    
    @Test
    @DisplayName("Test 5: Calcular ponderación con nota intermedia")
    public void testCalcularPonderacionNotaIntermedia() {
        double resultado = matematica.calcularPonderacion(3.7);
        // 3.7 * 0.45 = 1.665
        assertEquals(1.665, resultado, 0.001, "La ponderación de 3.7 en Matemática debería ser 1.665");
    }
    
    @Test
    @DisplayName("Test 6: Verificar que el porcentaje no cambia")
    public void testPorcentajeNoCambia() {
        double porcentajeOriginal = desarrollo.getPorcentaje();
        desarrollo.calcularPonderacion(4.0);
        assertEquals(porcentajeOriginal, desarrollo.getPorcentaje(), 0.001, 
                    "El porcentaje no debería cambiar después de calcular ponderación");
    }
    
    @Test
    @DisplayName("Test 7: Calcular ponderación con nota mayor a 5.0")
    public void testCalcularPonderacionNotaMayor() {
        double resultado = desarrollo.calcularPonderacion(6.0);
        // 6.0 * 0.55 = 3.3
        assertEquals(3.3, resultado, 0.001, 
                    "La ponderación debería calcularse incluso con notas mayores a 5.0");
    }
}