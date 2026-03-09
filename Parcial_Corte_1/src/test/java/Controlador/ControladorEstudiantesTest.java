package Controlador;

import controlador.ControladorEstudiantes;
import modelo.Estudiante;
import modelo.ModeloEstudiantes;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ControladorEstudiantesTest {
    private ControladorEstudiantes controlador;
    private ModeloEstudiantes modelo;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() throws Exception {
        controlador = new ControladorEstudiantes();
        System.setOut(new PrintStream(outContent));
        
        // Acceder al modelo privado usando reflexión
        Field modeloField = ControladorEstudiantes.class.getDeclaredField("modelo");
        modeloField.setAccessible(true);
        modelo = (ModeloEstudiantes) modeloField.get(controlador);
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }
    
    @Test
    @DisplayName("Test 1: Registrar un estudiante correctamente")
    public void testRegistrarUnEstudiante() throws Exception {
        // Simular entrada: 1 estudiante con datos válidos
        String input = "1\n21001\nJuan Pérez\n4.0\n3.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("registrarEstudiantes");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(1, modelo.getEstudiantes().size());
        Estudiante e = modelo.getEstudiantePorCodigo(21001);
        assertNotNull(e);
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals(4.0, e.getNotaDesarrollo());
        assertEquals(3.5, e.getNotaMatematica());
    }
    
    @Test
    @DisplayName("Test 2: Registrar con código inválido")
    public void testRegistrarCodigoInvalido() throws Exception {
        // Código 20000 es inválido, luego 21001 válido
        String input = "1\n20000\n21001\nJuan Pérez\n4.0\n3.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("registrarEstudiantes");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(1, modelo.getEstudiantes().size());
        assertNotNull(modelo.getEstudiantePorCodigo(21001));
        assertTrue(outContent.toString().contains("Error: El código debe ser mayor a 21000"));
    }
    
    @Test
    @DisplayName("Test 3: Registrar con nota inválida")
    public void testRegistrarNotaInvalida() throws Exception {
        // Nota 6.0 inválida, luego 4.0 válida
        String input = "1\n21001\nJuan Pérez\n6.0\n4.0\n3.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("registrarEstudiantes");
        method.setAccessible(true);
        method.invoke(controlador);
        
        Estudiante e = modelo.getEstudiantePorCodigo(21001);
        assertEquals(4.0, e.getNotaDesarrollo());
        assertTrue(outContent.toString().contains("Error: La nota debe estar entre 0.0 y 5.0"));
    }
    
    @Test
    @DisplayName("Test 4: Mostrar estudiantes sin registros")
    public void testMostrarEstudiantesVacio() throws Exception {
        Method method = controlador.getClass().getDeclaredMethod("mostrarEstudiantes");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertTrue(outContent.toString().contains("No hay estudiantes registrados"));
    }
    
    @Test
    @DisplayName("Test 5: Mostrar estudiantes con registros")
    public void testMostrarEstudiantesConDatos() throws Exception {
        modelo.agregarEstudiante(new Estudiante(21001, "Juan Pérez", 4.0, 3.5));
        modelo.agregarEstudiante(new Estudiante(21002, "María Gómez", 5.0, 4.5));
        
        Method method = controlador.getClass().getDeclaredMethod("mostrarEstudiantes");
        method.setAccessible(true);
        method.invoke(controlador);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("Juan Pérez"));
        assertTrue(salida.contains("María Gómez"));
        assertTrue(salida.contains("21001"));
        assertTrue(salida.contains("21002"));
    }
    
    @Test
    @DisplayName("Test 6: Filtrar por nota límite")
    public void testFiltrarPorNotaLimite() throws Exception {
        modelo.agregarEstudiante(new Estudiante(21001, "Juan", 4.0, 4.0)); // Def: 4.0
        modelo.agregarEstudiante(new Estudiante(21002, "María", 2.0, 2.0)); // Def: 2.0
        
        String input = "3.0\n"; // Nota límite
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("filtrarPorNotaLimite");
        method.setAccessible(true);
        method.invoke(controlador);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("Juan")); // Juan tiene 4.0 > 3.0
        assertFalse(salida.contains("María")); // María tiene 2.0 <= 3.0
    }
    
    @Test
    @DisplayName("Test 7: Incrementar notas de Desarrollo")
    public void testIncrementarNotas() throws Exception {
        Estudiante e1 = new Estudiante(21001, "Juan", 4.0, 3.5);
        Estudiante e2 = new Estudiante(21002, "María", 4.8, 4.0);
        modelo.agregarEstudiante(e1);
        modelo.agregarEstudiante(e2);
        
        String input = "0.3\n"; // Incremento
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("incrementarNotasDesarrollo");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(4.3, e1.getNotaDesarrollo());
        assertEquals(5.0, e2.getNotaDesarrollo()); // Límite máximo
        assertEquals(3.5, e1.getNotaMatematica()); // No cambia
    }
    
    @Test
    @DisplayName("Test 8: Incrementar con valor inválido")
    public void testIncrementarNotasValorInvalido() throws Exception {
        modelo.agregarEstudiante(new Estudiante(21001, "Juan", 4.0, 3.5));
        
        String input = "0.6\n0.2\n"; // 0.6 inválido, luego 0.2 válido
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("incrementarNotasDesarrollo");
        method.setAccessible(true);
        method.invoke(controlador);
        
        Estudiante e = modelo.getEstudiantePorCodigo(21001);
        assertEquals(4.2, e.getNotaDesarrollo());
        assertTrue(outContent.toString().contains("Error: El incremento debe estar entre 0.0 y 0.5"));
    }
    
    @Test
    @DisplayName("Test 9: Modificar nota de estudiante existente")
    public void testModificarNotaEstudianteExistente() throws Exception {
        Estudiante e = new Estudiante(21001, "Juan Pérez", 4.0, 3.5);
        modelo.agregarEstudiante(e);
        
        // Buscar código 21001, modificar Desarrollo (1), nueva nota 4.7
        String input = "21001\n1\n4.7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("modificarNotaEstudiante");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(4.7, e.getNotaDesarrollo());
        assertEquals(3.5, e.getNotaMatematica()); // No cambia
    }
    
    @Test
    @DisplayName("Test 10: Modificar nota de estudiante inexistente")
    public void testModificarNotaEstudianteInexistente() throws Exception {
        modelo.agregarEstudiante(new Estudiante(21001, "Juan", 4.0, 3.5));
        
        String input = "99999\n"; // Código que no existe
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("modificarNotaEstudiante");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertTrue(outContent.toString().contains("No se encontró estudiante"));
    }
    
    @Test
    @DisplayName("Test 11: Modificar nota de Matemática")
    public void testModificarNotaMatematica() throws Exception {
        Estudiante e = new Estudiante(21001, "Juan Pérez", 4.0, 3.5);
        modelo.agregarEstudiante(e);
        
        String input = "21001\n2\n4.2\n"; // Opción 2 = Matemática
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("modificarNotaEstudiante");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(4.0, e.getNotaDesarrollo()); // No cambia
        assertEquals(4.2, e.getNotaMatematica());
    }
    
    @Test
    @DisplayName("Test 12: Modificar con opción inválida")
    public void testModificarOpcionInvalida() throws Exception {
        Estudiante e = new Estudiante(21001, "Juan", 4.0, 3.5);
        modelo.agregarEstudiante(e);
        
        double desarrolloOriginal = e.getNotaDesarrollo();
        double matematicaOriginal = e.getNotaMatematica();
        
        String input = "21001\n3\n"; // Opción 3 inválida
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("modificarNotaEstudiante");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(desarrolloOriginal, e.getNotaDesarrollo());
        assertEquals(matematicaOriginal, e.getNotaMatematica());
        assertTrue(outContent.toString().contains("Opción no válida"));
    }
    
    @Test
    @DisplayName("Test 13: Modificar con nota inválida")
    public void testModificarNotaInvalida() throws Exception {
        Estudiante e = new Estudiante(21001, "Juan", 4.0, 3.5);
        modelo.agregarEstudiante(e);
        
        // Nota 5.5 inválida, luego 4.5 válida
        String input = "21001\n1\n5.5\n4.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method method = controlador.getClass().getDeclaredMethod("modificarNotaEstudiante");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertEquals(4.5, e.getNotaDesarrollo());
    }
    
    @Test
    @DisplayName("Test 14: Calcular promedios sin estudiantes")
    public void testCalcularPromediosSinEstudiantes() throws Exception {
        Method method = controlador.getClass().getDeclaredMethod("navegarYCalcularPromedios");
        method.setAccessible(true);
        method.invoke(controlador);
        
        assertTrue(outContent.toString().contains("No hay estudiantes registrados"));
    }
    
    @Test
    @DisplayName("Test 15: Calcular promedios con estudiantes")
    public void testCalcularPromediosConEstudiantes() throws Exception {
        modelo.agregarEstudiante(new Estudiante(21001, "Juan", 4.0, 3.0));
        modelo.agregarEstudiante(new Estudiante(21002, "María", 3.0, 5.0));
        
        Method method = controlador.getClass().getDeclaredMethod("navegarYCalcularPromedios");
        method.setAccessible(true);
        method.invoke(controlador);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("Promedio de notas por asignatura"));
        assertTrue(salida.contains("Desarrollo:"));
        assertTrue(salida.contains("Matemática:"));
    }
    
    @Test
    @DisplayName("Test 16: Ejecutar opción de salir")
    public void testEjecutarOpcionSalir() {
        String input = "7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        assertDoesNotThrow(() -> controlador.ejecutar());
    }
    
    @Test
    @DisplayName("Test 17: Ejecutar opción inválida")
    public void testEjecutarOpcionInvalida() {
        String input = "9\n7\n"; // Opción 9 inválida, luego 7 para salir
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        assertDoesNotThrow(() -> controlador.ejecutar());
        
        String salida = outContent.toString();
        assertTrue(salida.contains("Opción no válida"));
    }
    
    @Test
    @DisplayName("Test 18: Flujo completo de registro y consulta")
    public void testFlujoCompleto() throws Exception {
        // Registrar un estudiante
        String input = "1\n21001\nJuan Pérez\n4.0\n3.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Method registrar = controlador.getClass().getDeclaredMethod("registrarEstudiantes");
        registrar.setAccessible(true);
        registrar.invoke(controlador);
        
        // Verificar que se registró
        assertEquals(1, modelo.getEstudiantes().size());
        
        // Mostrar estudiantes
        outContent.reset();
        Method mostrar = controlador.getClass().getDeclaredMethod("mostrarEstudiantes");
        mostrar.setAccessible(true);
        mostrar.invoke(controlador);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("Juan Pérez"));
        assertTrue(salida.contains("21001"));
        assertTrue(salida.contains("4.0"));
        assertTrue(salida.contains("3.5"));
    }
}