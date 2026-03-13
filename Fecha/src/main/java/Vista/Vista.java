package Vista;

import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    public int pedirNumero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    public void mostrarResultado(int dias) {
        System.out.println("La diferencia de días es: " + dias);
    }
}
