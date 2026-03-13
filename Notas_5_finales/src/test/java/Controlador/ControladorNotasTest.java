import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VistaFalsa extends VistaNotas {

    private double[] notasSimuladas;
    private int resultadoMostrado;

    public VistaFalsa(double[] notas) {
        this.notasSimuladas = notas;
    }

    @Override
    public double[] pedirNotas() {
        return notasSimuladas;
    }

    @Override
    public void mostrarResultado(int cantidad) {
        resultadoMostrado = cantidad;
    }

    public int getResultadoMostrado() {
        return resultadoMostrado;
    }
}

public class ControladorNotasTest {

    @Test
    void testIniciar() {

        double[] notas = {4.0, 2.0, 3.5, 1.0, 5.0};

        ModeloNotas modelo = new ModeloNotas();
        VistaFalsa vistaFalsa = new VistaFalsa(notas);
        ControladorNotas controlador = new ControladorNotas(modelo, vistaFalsa);

        controlador.iniciar();

        assertEquals(3, vistaFalsa.getResultadoMostrado());
    }
}
