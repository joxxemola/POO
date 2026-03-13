public class ControladorNotas {

    private ModeloNotas modelo;
    private VistaNotas vista;

    public ControladorNotas(ModeloNotas modelo, VistaNotas vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        double[] notas = vista.pedirNotas();
        modelo.setNotas(notas);
        int cantidad = modelo.contarAprobadas();
        vista.mostrarResultado(cantidad);
    }
}
