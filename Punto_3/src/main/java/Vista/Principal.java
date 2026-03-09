package vista;

import controlador.EstudianteControlador;
import modelo.Estudiante;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EstudianteControlador controlador = new EstudianteControlador();

        System.out.print("Ingrese número de estudiantes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Estudiante #" + (i + 1));

            System.out.print("Código: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Nota Desarrollo: ");
            double desarrollo = sc.nextDouble();

            System.out.print("Nota Matemática: ");
            double matematica = sc.nextDouble();

            Estudiante estudiante = new Estudiante(codigo, nombre, desarrollo, matematica);
            controlador.agregarEstudiante(estudiante);
        }

        System.out.println("\n=== LISTADO COMPLETO ===");
        controlador.mostrarTodos();

        System.out.print("\nIngrese nota límite (0.0 - 4.9): ");
        double limite = sc.nextDouble();
        controlador.mostrarPorNotaLimite(limite);

        System.out.print("\nIngrese incremento (0.0 - 0.5): ");
        double incremento = sc.nextDouble();
        controlador.incrementarNotas(incremento);

        System.out.println("\n=== DESPUÉS DEL INCREMENTO ===");
        controlador.mostrarTodos();
    }
}