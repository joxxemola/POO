package controlador;

import modelo.ModeloNotas;
import vista.VistaNotas;

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

        int resultado = modelo.contarNotasMayoresIgualesA3();
        vista.mostrarResultado(resultado);
    }
}