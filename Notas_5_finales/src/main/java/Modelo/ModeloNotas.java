public class ModeloNotas {

    private double[] notas;

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public int contarAprobadas() {
        int contador = 0;
        for (double nota : notas) {
            if (nota >= 3.0) {
                contador++;
            }
        }
        return contador;
    }
}
