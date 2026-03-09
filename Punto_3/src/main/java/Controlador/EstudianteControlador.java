package controlador;

import modelo.Estudiante;
import java.util.ArrayList;

public class EstudianteControlador {

    private ArrayList<Estudiante> listaEstudiantes;

    public EstudianteControlador() {
        listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public void mostrarTodos() {
        for (Estudiante e : listaEstudiantes) {
            System.out.println("Código: " + e.getCodigo());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Definitiva: " + e.calcularDefinitiva());
            System.out.println("Estado: " + e.obtenerEstado());
            System.out.println("---------------------------");
        }
    }

    public void mostrarPorNotaLimite(double notaLimite) {
        for (Estudiante e : listaEstudiantes) {
            if (e.calcularDefinitiva() > notaLimite) {
                System.out.println("Código: " + e.getCodigo());
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Definitiva: " + e.calcularDefinitiva());
                System.out.println("---------------------------");
            }
        }
    }

    public void incrementarNotas(double incremento) {
        for (Estudiante e : listaEstudiantes) {
            e.incrementarDesarrollo(incremento);
        }
    }
}