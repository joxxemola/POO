/**
 *
 * @author Jose David Molano Perdomo
 */

package Modelo;

import modelo.Estudiante;
import modelo.ModeloEstudiantes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ModeloEstudiantesTest {
    private ModeloEstudiantes modelo;
    private Estudiante e1, e2, e3, e4;
    
    @BeforeEach
    public void setUp() {
        modelo = new ModeloEstudiantes();
        
        e1 = new Estudiante(21001, "Ana Torres", 2.0, 2.0);    // Definitiva: 2.0
        e2 = new Estudiante(21002, "Carlos Ruiz", 5.0, 5.0);   // Definitiva: 5.0
        e3 = new Estudiante(21003, "María Díaz", 3.0, 4.0);    // Definitiva: 3.45
        e4 = new Estudiante(21004, "Juan Pérez", 4.0, 3.5);    // Definitiva: 3.775
    }
    
    @Test
    @DisplayName("Test 1: Agregar estudiante y verificar lista")
    public void testAgregarEstudiante() {
        assertEquals(0, modelo.getEstudiantes().size(), "La lista debería estar vacía");
        
        modelo.agregarEstudiante(e1);
        assertEquals(1, modelo.getEstudiantes().size(), "Debería haber 1 estudiante");
        
        modelo.agregarEstudiante(e2);
        assertEquals(2, modelo.getEstudiantes().size(), "Debería haber 2 estudiantes");
    }
    
    @Test
    @DisplayName("Test 2: Obtener estudiante por código existente")
    public void testGetEstudiantePorCodigoExistente() {
        modelo.agregarEstudiante(e1);
        modelo.agregarEstudiante(e2);
        modelo.agregarEstudiante(e3);
        
        Estudiante encontrado = modelo.getEstudiantePorCodigo(21002);
        assertNotNull(encontrado, "Debería encontrar el estudiante");
        assertEquals("Carlos Ruiz", encontrado.getNombre(), "El nombre debería coincidir");
        assertEquals(21002, encontrado.getCodigo(), "El código debería coincidir");
    }
    
    @Test
    @DisplayName("Test 3: Obtener estudiante por código no existente")
    public void testGetEstudiantePorCodigoNoExistente() {
        modelo.agregarEstudiante(e1);
        modelo.agregarEstudiante(e2);
        
        Estudiante encontrado = modelo.getEstudiantePorCodigo(99999);
        assertNull(encontrado, "No debería encontrar el estudiante");
    }
    
    @Test
    @DisplayName("Test 4: Obtener estudiante con lista vacía")
    public void testGetEstudiantePorCodigoListaVacia() {
        Estudiante encontrado = modelo.getEstudiantePorCodigo(21001);
        assertNull(encontrado, "Con lista vacía no debería encontrar nada");
    }
    
    @Test
    @DisplayName("Test 5: Ordenar por nota definitiva - orden ascendente")
    public void testOrdenarPorNotaDefinitiva() {
        modelo.agregarEstudiante(e1); // 2.0
        modelo.agregarEstudiante(e2); // 5.0
        modelo.agregarEstudiante(e3); // 3.45
        modelo.agregarEstudiante(e4); // 3.775
        
        modelo.ordenarPorNotaDefinitiva();
        
        ArrayList<Estudiante> lista = modelo.getEstudiantes();
        
        // Verificar orden ascendente
        assertEquals(21001, lista.get(0).getCodigo(), "Primero debería ser Ana (2.0)");
        assertEquals(21003, lista.get(1).getCodigo(), "Segundo debería ser María (3.45)");
        assertEquals(21004, lista.get(2).getCodigo(), "Tercero debería ser Juan (3.775)");
        assertEquals(21002, lista.get(3).getCodigo(), "Último debería ser Carlos (5.0)");
    }
    
    @Test
    @DisplayName("Test 6: Ordenar con notas iguales")
    public void testOrdenarConNotasIguales() {
        Estudiante a = new Estudiante(21005, "Luis", 4.0, 4.0); // Def: 4.0
        Estudiante b = new Estudiante(21006, "Elena", 4.0, 4.0); // Def: 4.0
        
        modelo.agregarEstudiante(b);
        modelo.agregarEstudiante(a);
        
        modelo.ordenarPorNotaDefinitiva();
        
        ArrayList<Estudiante> lista = modelo.getEstudiantes();
        // Con notas iguales, puede quedar en cualquier orden, pero deben ser los mismos
        assertTrue(lista.contains(a) && lista.contains(b), 
                   "Ambos estudiantes deben estar en la lista");
    }
    
    @Test
    @DisplayName("Test 7: Ordenar con un solo estudiante")
    public void testOrdenarUnSoloEstudiante() {
        modelo.agregarEstudiante(e1);
        
        modelo.ordenarPorNotaDefinitiva();
        
        ArrayList<Estudiante> lista = modelo.getEstudiantes();
        assertEquals(1, lista.size(), "Debe haber un estudiante");
        assertEquals(21001, lista.get(0).getCodigo(), "Debe ser el mismo estudiante");
    }
    
    @Test
    @DisplayName("Test 8: Ordenar con lista vacía")
    public void testOrdenarListaVacia() {
        modelo.ordenarPorNotaDefinitiva(); // No debería lanzar excepción
        assertEquals(0, modelo.getEstudiantes().size(), "La lista debe seguir vacía");
    }
    
    @Test
    @DisplayName("Test 9: Calcular aprobación - Aprueba")
    public void testCalcularAprobacionAprueba() {
        assertEquals("SI APRUEBA", modelo.calcularAprobacion(4.0), 
                    "4.0 debería aprobar");
        assertEquals("SI APRUEBA", modelo.calcularAprobacion(3.5), 
                    "3.5 debería aprobar");
        assertEquals("SI APRUEBA", modelo.calcularAprobacion(5.0), 
                    "5.0 debería aprobar");
    }
    
    @Test
    @DisplayName("Test 10: Calcular aprobación - No aprueba")
    public void testCalcularAprobacionNoAprueba() {
        assertEquals("NO APRUEBA", modelo.calcularAprobacion(3.4), 
                    "3.4 no debería aprobar");
        assertEquals("NO APRUEBA", modelo.calcularAprobacion(2.0), 
                    "2.0 no debería aprobar");
        assertEquals("NO APRUEBA", modelo.calcularAprobacion(0.0), 
                    "0.0 no debería aprobar");
    }
    
    @Test
    @DisplayName("Test 11: Navegar y calcular promedios - Múltiples estudiantes")
    public void testNavegarYCalcularPromediosMultiples() {
        modelo.agregarEstudiante(e1); // D:2.0, M:2.0
        modelo.agregarEstudiante(e2); // D:5.0, M:5.0
        modelo.agregarEstudiante(e3); // D:3.0, M:4.0
        
        double[] promedios = modelo.navegarYCalcularPromedioAsignaturas();
        
        // Promedio Desarrollo: (2.0 + 5.0 + 3.0) / 3 = 10/3 = 3.333...
        assertEquals(3.333, promedios[0], 0.01, "Promedio Desarrollo incorrecto");
        
        // Promedio Matemática: (2.0 + 5.0 + 4.0) / 3 = 11/3 = 3.666...
        assertEquals(3.667, promedios[1], 0.01, "Promedio Matemática incorrecto");
    }
    
    @Test
    @DisplayName("Test 12: Navegar y calcular promedios - Un estudiante")
    public void testNavegarYCalcularPromediosUnEstudiante() {
        modelo.agregarEstudiante(e4); // D:4.0, M:3.5
        
        double[] promedios = modelo.navegarYCalcularPromedioAsignaturas();
        
        assertEquals(4.0, promedios[0], 0.001, "Promedio Desarrollo incorrecto");
        assertEquals(3.5, promedios[1], 0.001, "Promedio Matemática incorrecto");
    }
    
    @Test
    @DisplayName("Test 13: Navegar y calcular promedios - Lista vacía")
    public void testNavegarYCalcularPromediosListaVacia() {
        double[] promedios = modelo.navegarYCalcularPromedioAsignaturas();
        
        assertEquals(0.0, promedios[0], 0.001, "Con lista vacía, promedio debe ser 0");
        assertEquals(0.0, promedios[1], 0.001, "Con lista vacía, promedio debe ser 0");
    }
    
    @Test
    @DisplayName("Test 14: Verificar que getEstudiantes devuelve la lista correcta")
    public void testGetEstudiantes() {
        modelo.agregarEstudiante(e1);
        modelo.agregarEstudiante(e2);
        
        ArrayList<Estudiante> lista = modelo.getEstudiantes();
        
        assertEquals(2, lista.size(), "La lista debe tener 2 elementos");
        assertTrue(lista.contains(e1), "La lista debe contener a e1");
        assertTrue(lista.contains(e2), "La lista debe contener a e2");
    }
    
    @Test
    @DisplayName("Test 15: Integración - Agregar, buscar y ordenar")
    public void testIntegracionCompleta() {
        // Agregar estudiantes
        modelo.agregarEstudiante(e2); // 5.0
        modelo.agregarEstudiante(e1); // 2.0
        modelo.agregarEstudiante(e4); // 3.775
        
        // Buscar estudiante
        Estudiante encontrado = modelo.getEstudiantePorCodigo(21002);
        assertNotNull(encontrado);
        assertEquals("Carlos Ruiz", encontrado.getNombre());
        
        // Ordenar
        modelo.ordenarPorNotaDefinitiva();
        
        ArrayList<Estudiante> lista = modelo.getEstudiantes();
        assertEquals(21001, lista.get(0).getCodigo(), "El orden ascendente no es correcto");
        assertEquals(21004, lista.get(1).getCodigo(), "El orden ascendente no es correcto");
        assertEquals(21002, lista.get(2).getCodigo(), "El orden ascendente no es correcto");
        
        // Calcular promedios
        double[] promedios = modelo.navegarYCalcularPromedioAsignaturas();
        assertTrue(promedios[0] > 0, "Los promedios deberían ser positivos");
    }
}