import java.util.Scanner;

public class VistaNotas {

    private Scanner scanner = new Scanner(System.in);

    public double[] pedirNotas() {
        double[] notas = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese la nota #" + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        return notas;
    }

    public void mostrarResultado(int cantidad) {
        System.out.println("Cantidad de notas mayores o iguales a 3.0: " + cantidad);
    }
}
