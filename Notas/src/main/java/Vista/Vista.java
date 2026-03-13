package Vista;

import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    public int pedirNota() {
        System.out.print("Ingrese una nota (0-10): ");
        return sc.nextInt();
    }

    public void mostrarNota(String texto) {
        System.out.println("La nota es: " + texto);
    }
}
