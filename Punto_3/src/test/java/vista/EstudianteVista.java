package vista;

import modelo.Estudiante;

public class EstudianteVista {

    public void mostrarEstudiante(Estudiante e) {
        System.out.println("Código: " + e.getCodigo());
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Definitiva: " + e.calcularDefinitiva());
        System.out.println("Estado: " + e.obtenerEstado());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}