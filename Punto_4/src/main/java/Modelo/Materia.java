package modelo;

public class Materia {

    private String codMat;     // 3 a 5 caracteres
    private String nomMat;     // No vacío
    private int numGrupos;     // 1 a 12
    private Grupo[] grupos;
    private int indice;

    public Materia(String codMat, String nomMat, int numGrupos) {

        if (codMat.length() < 3 || codMat.length() > 5)
            throw new IllegalArgumentException("Código materia inválido");

        if (nomMat == null || nomMat.isEmpty())
            throw new IllegalArgumentException("Nombre vacío");

        if (numGrupos < 1 || numGrupos > 12)
            throw new IllegalArgumentException("Cantidad de grupos inválida");

        this.codMat = codMat;
        this.nomMat = nomMat;
        this.numGrupos = numGrupos;
        this.grupos = new Grupo[numGrupos];
        this.indice = 0;
    }

    public void agregarGrupo(Grupo grupo) {
        if (indice < numGrupos) {
            grupos[indice++] = grupo;
        }
    }

    public Grupo buscarGrupo(int codGrupo) {
        for (Grupo g : grupos) {
            if (g != null && g.getCodGrupo() == codGrupo) {
                return g;
            }
        }
        return null;
    }

    public double obtenerMayorPromedio() {
        double mayor = 0;
        for (Grupo g : grupos) {
            if (g != null && g.getPromGrupo() > mayor) {
                mayor = g.getPromGrupo();
            }
        }
        return mayor;
    }

    public String generarReporte() {
        String reporte = "Materia: " + nomMat + "\n";
        for (Grupo g : grupos) {
            if (g != null) {
                reporte += g.toString() + "\n";
            }
        }
        return reporte;
    }

    public void cambiarProfesor(int codGrupo, String nuevoProfesor) {
        Grupo g = buscarGrupo(codGrupo);
        if (g != null) {
            g.setProfesor(nuevoProfesor);
        }
    }
}