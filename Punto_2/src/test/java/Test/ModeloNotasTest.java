package Test;

import modelo.ModeloNotas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ModeloNotasTest {

    @Test
    public void pruebaCasoNormal() {
        double[] notas = {3.0, 4.5, 2.0, 3.8, 1.5};
        ModeloNotas modelo = new ModeloNotas(notas);

        int resultado = modelo.contarNotasMayoresIgualesA3();

        assertEquals(3, resultado);
    }

    @Test
    public void pruebaTodasReprobadas() {
        double[] notas = {1.0, 2.0, 2.9, 0.5, 1.8};
        ModeloNotas modelo = new ModeloNotas(notas);

        int resultado = modelo.contarNotasMayoresIgualesA3();

        assertEquals(0, resultado);
    }

    @Test
    public void pruebaTodasAprobadas() {
        double[] notas = {3.0, 3.1, 4.0, 5.0, 3.5};
        ModeloNotas modelo = new ModeloNotas(notas);

        int resultado = modelo.contarNotasMayoresIgualesA3();

        assertEquals(5, resultado);
    }
}