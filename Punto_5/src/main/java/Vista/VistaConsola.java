package vista;

import modelo.Cliente;
import modelo.Factura;
import modelo.SalaCine;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public int pedirNumeroSala() {
        System.out.print("Ingrese el número de sala (1-6): ");
        return scanner.nextInt();
    }

    public int pedirNumeroFacturas(int salaNumero) {
        System.out.print("¿Cuántas facturas desea ingresar para la sala " + salaNumero + "? ");
        return scanner.nextInt();
    }

    public Cliente pedirDatosCliente() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("  Nombre del comprador: ");
        String nombre = scanner.nextLine();
        System.out.print("  ¿Tiene tarjeta de descuento? (s/n): ");
        String tarjeta = scanner.nextLine();
        boolean tieneTarjeta = tarjeta.equalsIgnoreCase("s");
        return new Cliente(nombre, tieneTarjeta);
    }

    public Factura pedirDatosFactura(Cliente cliente, int numeroFactura) {
        System.out.println("  --- Factura #" + numeroFactura + " ---");
        System.out.println("  Promotoras disponibles: Cine Colombia, Royal Films");
        System.out.print("  Promotora: ");
        String promotora = scanner.nextLine();
        
        System.out.println("  Tipos de función: 35 mm, 3D");
        System.out.print("  Tipo de función: ");
        String tipoFuncion = scanner.nextLine();
        
        System.out.print("  Número de boletas: ");
        int numBoletas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        return new Factura(cliente, promotora, tipoFuncion, numBoletas);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarReporte(SalaCine sala, int numeroSala) {
        System.out.println("\n========== REPORTE DE VENTAS - SALA " + numeroSala + " ==========");
        
        // (1) Mostrar información de cada factura
        System.out.println("\n--- DETALLE DE FACTURAS ---");
        for (Factura f : sala.getFacturas()) {
            Cliente c = f.getCliente();
            System.out.println("Cliente: " + c.getNombre());
            System.out.println("  Promotora: " + f.getPromotora());
            System.out.println("  Tipo función: " + f.getTipoFuncion());
            System.out.println("  Número de boletas: " + f.getNumBoletas());
            System.out.println("  Tarjeta descuento: " + (c.isTieneTarjeta() ? "Sí" : "No"));
            System.out.println("  Total a pagar: $" + String.format("%.2f", f.calcularTotal()));
            System.out.println();
        }
        
        // (2) Dinero recibido por la sala
        System.out.println("(2) Dinero recibido en sala: $" + String.format("%.2f", sala.dineroRecibido()));
        
        // (3) Dinero facturado por cada promotora
        System.out.println("(3) Total Cine Colombia: $" + String.format("%.2f", sala.facturarPorPromotora("Cine Colombia")));
        System.out.println("    Total Royal Films: $" + String.format("%.2f", sala.facturarPorPromotora("Royal Films")));
        
        // (4) Tipo de función más vendida
        System.out.println("(4) Tipo de función más vendida: " + sala.tipoFuncionMasVendida());
    }

    public void cerrar() {
        scanner.close();
    }
}