/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */

public class Modelo {

    private int nota;

    // Getter
    public int getNota() {
        return nota;
    }

    // Setter
    public void setNota(int nota) {
        this.nota = nota;
    }

    // Método para evaluar la nota
    public String evaluarNota() {
        if (nota >= 0 && nota <= 4) {
            return "Insuficiente";
        }
        else if (nota == 5) {
            return "Suficiente";
        } 
        else if (nota >= 6 && nota <= 7) {
            return "Bien";
        } 
        else if (nota >= 8 && nota <= 10) {
            return "Excelente";
        } 
        else {
            return "Nota inválida";
        }
    }
}

