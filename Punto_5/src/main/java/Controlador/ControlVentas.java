package controlador;

import modelo.Cliente;
import modelo.Factura;
import modelo.SalaCine;
import vista.VistaConsola;

public class ControlVentas {
    private VistaConsola vista;
    private SalaCine[] salas;

    public ControlVentas(VistaConsola vista) {
        this.vista = vista;
        this.salas = new SalaCine[7]; // índice 1-6, ignoramos índice 0
        for (int i = 1; i <= 6; i++) {
            salas[i] = new SalaCine(i);
        }
    }

    public void ejecutar() {
        try {
            // Solicitar número de sala
            int numSala = vista.pedirNumeroSala();
            if (numSala < 1 || numSala > 6) {
                vista.mostrarMensaje("Error: El número de sala debe ser entre 1 y 6");
                return;
            }

            // Solicitar facturas para esa sala
            int numFacturas = vista.pedirNumeroFacturas(numSala);
            if (numFacturas <= 0) {
                vista.mostrarMensaje("Debe ingresar al menos una factura");
                return;
            }

            for (int j = 0; j < numFacturas; j++) {
                vista.mostrarMensaje("\n--- Ingresando factura " + (j + 1) + " para sala " + numSala + " ---");
                Cliente cliente = vista.pedirDatosCliente();
                Factura factura = vista.pedirDatosFactura(cliente, j + 1);
                salas[numSala].agregarFactura(factura);
            }

            // Mostrar reporte de la sala seleccionada
            vista.mostrarReporte(salas[numSala], numSala);

        } catch (Exception e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } finally {
            vista.cerrar();
        }
    }
}