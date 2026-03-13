public class Main {

    public static void main(String[] args) {

        ModeloNotas modelo = new ModeloNotas();
        VistaNotas vista = new VistaNotas();
        ControladorNotas controlador = new ControladorNotas(modelo, vista);

        controlador.iniciar();
    }
}
