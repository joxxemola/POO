import controlador.ControlVentas;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControlVentas control = new ControlVentas(vista);
        control.ejecutar();
    }
}