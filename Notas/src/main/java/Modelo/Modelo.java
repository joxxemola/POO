package Modelo;

public class Modelo {
    private int nota;

    public Modelo(int nota) {
        this.nota = nota;
    }

    public int getNota() { return nota; }
    public void setNota(int nota) { this.nota = nota; }

    public String notaEnTexto() {
        switch (nota) {
            case 0: return "Cero";
            case 1: return "Uno";
            case 2: return "Dos";
            case 3: return "Tres";
            case 4: return "Cuatro";
            case 5: return "Cinco";
            case 6: return "Seis";
            case 7: return "Siete";
            case 8: return "Ocho";
            case 9: return "Nueve";
            case 10: return "Diez";
            default: return "Nota inválida";
        }
    }
}
