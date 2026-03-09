package vista;

import java.util.Scanner;

public class VistaNotas {

    private Scanner lector = new Scanner(System.in);

    public double[] pedirNotas() {
        double[] notas = new double[5];

        System.out.println("Ingrese 5 notas finales:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = lector.nextDouble();
        }

        return notas;
    }

    public void mostrarResultado(int cantidad) {
        System.out.println("Cantidad de notas mayores o iguales a 3.0: " + cantidad);
    }
}