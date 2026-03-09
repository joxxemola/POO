package controlador;

import modelo.Grupo;
import modelo.Materia;

public class ControladorMateria {

    private Materia materia;

    public ControladorMateria(Materia materia) {
        this.materia = materia;
    }

    public void crearGrupo(int codGrupo, String profesor,
                           double prom, int numEst, int ganaron) {

        Grupo grupo = new Grupo(codGrupo, profesor, prom, numEst, ganaron);
        materia.agregarGrupo(grupo);
    }

    public String mostrarReporte() {
        return materia.generarReporte();
    }

    public String buscarGrupo(int codGrupo) {
        Grupo g = materia.buscarGrupo(codGrupo);
        if (g != null)
            return g.toString();
        else
            return "No existe un grupo con este código de grupo";
    }

    public double calcularPorcentajePerdida(int codGrupo) {
        Grupo g = materia.buscarGrupo(codGrupo);
        if (g != null)
            return g.calcularPorcentajePerdida();
        else
            return -1;
    }

    public double obtenerMayorPromedio() {
        return materia.obtenerMayorPromedio();
    }

    public void cambiarProfesor(int codGrupo, String nuevoProfesor) {
        materia.cambiarProfesor(codGrupo, nuevoProfesor);
    }
}