package modelo;

public class Grupo {

    private int codGrupo;          // 1 a 60
    private String profesor;       // No vacío
    private double promGrupo;      // 0.0 a 5.0
    private int numEstudiantes;    // 0 a 25
    private int ganaron;           // 0 a numEstudiantes

    public Grupo(int codGrupo, String profesor, double promGrupo,
                 int numEstudiantes, int ganaron) {

        if (codGrupo < 1 || codGrupo > 60)
            throw new IllegalArgumentException("Código inválido");

        if (profesor == null || profesor.isEmpty())
            throw new IllegalArgumentException("Profesor vacío");

        if (promGrupo < 0.0 || promGrupo > 5.0)
            throw new IllegalArgumentException("Promedio inválido");

        if (numEstudiantes < 0 || numEstudiantes > 25)
            throw new IllegalArgumentException("Número de estudiantes inválido");

        if (ganaron < 0 || ganaron > numEstudiantes)
            throw new IllegalArgumentException("Cantidad de ganaron inválida");

        this.codGrupo = codGrupo;
        this.profesor = profesor;
        this.promGrupo = promGrupo;
        this.numEstudiantes = numEstudiantes;
        this.ganaron = ganaron;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        if (profesor == null || profesor.isEmpty())
            throw new IllegalArgumentException("Profesor vacío");
        this.profesor = profesor;
    }

    public double getPromGrupo() {
        return promGrupo;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public int getGanaron() {
        return ganaron;
    }

    public double calcularPorcentajePerdida() {
        if (numEstudiantes == 0) return 0;
        int perdieron = numEstudiantes - ganaron;
        return (perdieron * 100.0) / numEstudiantes;
    }

    @Override
    public String toString() {
        return "Grupo: " + codGrupo +
                ", Profesor: " + profesor +
                ", Promedio: " + promGrupo +
                ", Estudiantes: " + numEstudiantes +
                ", Ganaron: " + ganaron;
    }
}