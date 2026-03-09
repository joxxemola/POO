/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author emgallego
 */
public class NumeroModelo {
    //atributos

    private int numero1;
    private int numero2;
    private int numero3;

    public NumeroModelo() {
    }

    public NumeroModelo(int numero1, int numero2, int numero3) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;

    }

    //getters y los setters
    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero3() {
        return numero3;
    }

    public void setNumero3(int numero3) {
        this.numero3 = numero3;
    }

    public int calcularMayor() {
        int mayor = this.numero1;
        if (this.numero2 > mayor) {
            mayor = this.numero2;
        }
        if (this.numero3 > mayor) {
            mayor = this.numero3;
        }
        return mayor;
    }
    
    public String numerosRepetidos() {
        if (numero1 == numero2 && numero2 == numero3) {
            return "Los tres números son iguales";
        } 
        else if (numero1 == numero2) {
            return "El número 1 y el número 2 son iguales";
        } 
        else if (numero1 == numero3) {
            return "El número 1 y el número 3 son iguales";
        }
        else if (numero2 == numero3) {
            return "El número 2 y el número 3 son iguales";
        }
        else {
            return "No hay números repetidos";
        }
    
    }


}
