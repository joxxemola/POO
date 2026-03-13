import java.util.Scanner;

public class Vista {

    private Scanner scanner = new Scanner(System.in);

    public int pedirNumero() {
        System.out.print("Ingrese un número: ");
        return scanner.nextInt();
    }

    public void mostrarResultado(int digitos) {
        System.out.println("El número tiene " + digitos + " dígitos.");
    }
}
