package principal;

import modelo.ModeloNotas;
import vista.VistaNotas;
import controlador.ControladorNotas;

public class Principal {

    public static void main(String[] args) {

        ModeloNotas modelo = new ModeloNotas(new double[5]);
        VistaNotas vista = new VistaNotas();
        ControladorNotas controlador = new ControladorNotas(modelo, vista);

        controlador.iniciar();
    }
}