package principal;

import modelo.Materia;
import controlador.ControladorMateria;
import vista.VistaMateria;

public class Main {

    public static void main(String[] args) {

        Materia materia = new Materia("POO1", "Programacion", 3);

        ControladorMateria controlador = new ControladorMateria(materia);

        VistaMateria vista = new VistaMateria(controlador);

        vista.iniciar();
    }
}