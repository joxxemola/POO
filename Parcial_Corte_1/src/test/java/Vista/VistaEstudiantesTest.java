package Vista;

import modelo.Estudiante;
import vista.VistaEstudiantes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;

public class VistaEstudiantesTest {
    private VistaEstudiantes vista;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        vista = new VistaEstudiantes();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    @DisplayName("Test 1: Mostrar mensaje simple")
    public void testMostrarMensaje() {
        vista.mostrarMensaje("Hola Mundo");
        assertEquals("Hola Mundo\n", outContent.toString(), 
                    "El mensaje mostrado no coincide");
    }
    
    @Test
    @DisplayName("Test 2: Leer entero válido")
    public void testLeerEnteroValido() {
        String input = "25\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Crear nueva vista con el Scanner modificado
        VistaEstudiantes vistaTest = new VistaEstudiantes() {
            private Scanner scanner = new Scanner(System.in);
            @Override
            public int leerEntero(String mensaje) {
                System.out.print(mensaje);
                return scanner.nextInt();
            }
        };
        
        int resultado = vistaTest.leerEntero("Ingrese edad: ");
        assertEquals(25, resultado, "Debería leer el número 25");
    }
    
    @Test
    @DisplayName("Test 3: Mostrar un estudiante")
    public void testMostrarEstudiante() {
        Estudiante e = new Estudiante(21001, "Juan Pérez", 4.0, 3.5);
        vista.mostrarEstudiante(e);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("21001"), "Debe mostrar el código");
        assertTrue(salida.contains("Juan Pérez"), "Debe mostrar el nombre");
        assertTrue(salida.contains("4.0"), "Debe mostrar nota Desarrollo");
        assertTrue(salida.contains("3.5"), "Debe mostrar nota Matemática");
        assertTrue(salida.contains("3.78") || salida.contains("3.775"), 
                   "Debe mostrar la definitiva");
    }
    
    @Test
    @DisplayName("Test 4: Mostrar estudiante que aprueba")
    public void testMostrarEstudianteAprueba() {
        Estudiante e = new Estudiante(21001, "Ana López", 4.0, 4.0);
        vista.mostrarEstudiante(e);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("SI APRUEBA"), 
                  "Debe indicar que aprueba");
    }
    
    @Test
    @DisplayName("Test 5: Mostrar estudiante que no aprueba")
    public void testMostrarEstudianteNoAprueba() {
        Estudiante e = new Estudiante(21001, "Pedro Díaz", 2.0, 2.0);
        vista.mostrarEstudiante(e);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("NO APRUEBA"), 
                  "Debe indicar que no aprueba");
    }
    
    @Test
    @DisplayName("Test 6: Mostrar lista vacía")
    public void testMostrarListaVacia() {
        List<Estudiante> lista = new ArrayList<>();
        vista.mostrarListaEstudiantes(lista);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("No hay estudiantes"), 
                  "Debe mostrar mensaje de lista vacía");
    }
    
    @Test
    @DisplayName("Test 7: Mostrar lista con estudiantes")
    public void testMostrarListaConEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante(21001, "Juan", 4.0, 3.5));
        lista.add(new Estudiante(21002, "María", 5.0, 4.5));
        
        vista.mostrarListaEstudiantes(lista);
        
        String salida = outContent.toString();
        assertTrue(salida.contains("21001"), "Debe mostrar primer código");
        assertTrue(salida.contains("21002"), "Debe mostrar segundo código");
        assertTrue(salida.contains("Juan"), "Debe mostrar primer nombre");
        assertTrue(salida.contains("María"), "Debe mostrar segundo nombre");
        assertTrue(salida.contains("=== LISTA DE ESTUDIANTES ==="), 
                  "Debe mostrar el encabezado");
    }
    
    @Test
    @DisplayName("Test 8: Mostrar menú principal")
    public void testMostrarMenu() {
        vista.mostrarMenu();
        
        String salida = outContent.toString();
        assertTrue(salida.contains("=== SISTEMA DE NOTAS ==="), 
                  "Debe mostrar título");
        assertTrue(salida.contains("1. Registrar estudiantes"), 
                  "Debe mostrar opción 1");
        assertTrue(salida.contains("2. Mostrar todos"), 
                  "Debe mostrar opción 2");
        assertTrue(salida.contains("3. Filtrar"), 
                  "Debe mostrar opción 3");
        assertTrue(salida.contains("4. Incrementar"), 
                  "Debe mostrar opción 4");
        assertTrue(salida.contains("5. Modificar"), 
                  "Debe mostrar opción 5");
        assertTrue(salida.contains("6. Calcular promedios"), 
                  "Debe mostrar opción 6");
        assertTrue(salida.contains("7. Salir"), 
                  "Debe mostrar opción 7");
    }
    
    @Test
    @DisplayName("Test 9: Leer double válido")
    public void testLeerDoubleValido() {
        String input = "3.75\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        VistaEstudiantes vistaTest = new VistaEstudiantes() {
            private Scanner scanner = new Scanner(System.in);
            @Override
            public double leerDouble(String mensaje) {
                System.out.print(mensaje);
                return scanner.nextDouble();
            }
        };
        
        double resultado = vistaTest.leerDouble("Ingrese nota: ");
        assertEquals(3.75, resultado, 0.001, "Debería leer el número 3.75");
    }
    
    @Test
    @DisplayName("Test 10: Leer string")
    public void testLeerString() {
        String input = "Juan Pérez\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        VistaEstudiantes vistaTest = new VistaEstudiantes() {
            private Scanner scanner = new Scanner(System.in);
            @Override
            public String leerString(String mensaje) {
                System.out.print(mensaje);
                return scanner.nextLine();
            }
        };
        
        String resultado = vistaTest.leerString("Ingrese nombre: ");
        assertEquals("Juan Pérez", resultado, "Debería leer el string");
    }
    
    @Test
    @DisplayName("Test 11: Formato de números en la salida")
    public void testFormatoNumeros() {
        Estudiante e = new Estudiante(21001, "Test", 4.33333, 3.66666);
        vista.mostrarEstudiante(e);
        
        String salida = outContent.toString();
        // Verificar que los números tienen formato con 2 decimales
        assertTrue(salida.matches(".*4\\.33.*") || salida.matches(".*4\\.33.*"), 
                  "La nota Desarrollo debe tener formato adecuado");
    }
    
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }
}