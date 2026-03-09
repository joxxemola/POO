/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author emgallego
 */
import java.util.Scanner;
public class Vista {
    private Scanner scanner;
    
    public Vista(){
        scanner = new Scanner(System.in);
    }
    
    //metodo para  pedir  los numeros
    public int pedirNumero(String orden){
        System.out.println("Ingresa el"+orden+"del numero: ");
        return scanner.nextInt();
    }
    
    //metodo mostrarResultado
    public void mostrarResultado(int mayor){
        System.out.println("<...........................>");
        System.out.println("<el número mayor  a  tres  números es: >"+ mayor);
        System.out.println("<...........................>");
    }
    
    public void mostrarRepetidos(String mensaje) {
        System.out.println("<--------------------------->");
        System.out.println(mensaje);
        System.out.println("<--------------------------->");
    }
}
