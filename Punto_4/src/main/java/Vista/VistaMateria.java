package vista;

import controlador.ControladorMateria;
import java.util.Scanner;

public class VistaMateria {

    private ControladorMateria controlador;
    private Scanner sc;

    public VistaMateria(ControladorMateria controlador) {
        this.controlador = controlador;
        sc = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n1. Crear grupo");
            System.out.println("2. Mostrar reporte");
            System.out.println("3. Buscar grupo");
            System.out.println("4. Calcular porcentaje pérdida");
            System.out.println("5. Obtener mayor promedio");
            System.out.println("6. Cambiar profesor");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Código grupo: ");
                    int cod = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Profesor: ");
                    String prof = sc.nextLine();

                    System.out.print("Promedio: ");
                    double prom = sc.nextDouble();

                    System.out.print("Número estudiantes: ");
                    int numEst = sc.nextInt();

                    System.out.print("Ganaron: ");
                    int gan = sc.nextInt();

                    controlador.crearGrupo(cod, prof, prom, numEst, gan);
                    break;

                case 2:
                    System.out.println(controlador.mostrarReporte());
                    break;

                case 3:
                    System.out.print("Código grupo: ");
                    System.out.println(controlador.buscarGrupo(sc.nextInt()));
                    break;

                case 4:
                    System.out.print("Código grupo: ");
                    System.out.println("Porcentaje pérdida: " +
                            controlador.calcularPorcentajePerdida(sc.nextInt()) + "%");
                    break;

                case 5:
                    System.out.println("Mayor promedio: " +
                            controlador.obtenerMayorPromedio());
                    break;

                case 6:
                    System.out.print("Código grupo: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo profesor: ");
                    String nuevo = sc.nextLine();
                    controlador.cambiarProfesor(codigo, nuevo);
                    break;
            }

        } while (opcion != 0);
    }
}