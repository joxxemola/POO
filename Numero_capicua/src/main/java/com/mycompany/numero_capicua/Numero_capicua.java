package com.mycompany.numero_capicua;

import java.util.Scanner;

public class Numero_capicua {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt();

        int original = numero;
        int invertido = 0;

        while (numero > 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero = numero / 10;
        }

        if (original == invertido) {
            System.out.println("El número es capicúa");
        } else {
            System.out.println("El número NO es capicúa");
        }
    }
}
