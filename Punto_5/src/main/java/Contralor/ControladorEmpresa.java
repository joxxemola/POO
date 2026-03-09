package Controlador;

import Modelo.*;

public class ControladorEmpresa {

    private final Empresa empresa;

    public ControladorEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Factura registrarVenta(int sala,
                                  String nombre,
                                  boolean tarjeta,
                                  String promotora,
                                  String tipo,
                                  int cantidad) {

        Cliente cliente = new Cliente(nombre, tarjeta);
        Factura factura = new Factura(cliente, promotora, tipo, cantidad);

        empresa.agregarFactura(sala, factura);

        return factura;
    }

    public double totalCineColombia() {
        return empresa.totalPorPromotora("Cine Colombia");
    }

    public double totalRoyalFilms() {
        return empresa.totalPorPromotora("Royal Films");
    }

    public String tipoMasVendido() {
        return empresa.tipoFuncionMasVendida();
    }
}