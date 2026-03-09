package modelo;

public class ModeloNotas {
    
    private double[] notas;

    public ModeloNotas(double[] notas) {
        this.notas = notas;
    }

    public int contarNotasMayoresIgualesA3() {
        int contador = 0;

        for (double nota : notas) {
            if (nota >= 3.0) {
                contador++;
            }
        }

        return contador;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}