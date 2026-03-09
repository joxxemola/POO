package modelo;

import java.util.ArrayList;
import java.util.List;

public class SalaCine {
    private int numero;
    private List<Factura> facturas;

    public SalaCine(int numero) {
        this.numero = numero;
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public double dineroRecibido() {
        double total = 0;
        for (Factura f : facturas) {
            total += f.calcularTotal();
        }
        return total;
    }

    public double facturarPorPromotora(String promotora) {
        double total = 0;
        for (Factura f : facturas) {
            if (f.getPromotora().equalsIgnoreCase(promotora)) {
                total += f.calcularTotal();
            }
        }
        return total;
    }

    public String tipoFuncionMasVendida() {
        int boletas35mm = 0;
        int boletas3D = 0;
        
        for (Factura f : facturas) {
            if (f.getTipoFuncion().equalsIgnoreCase("35 mm")) {
                boletas35mm += f.getNumBoletas();
            } else if (f.getTipoFuncion().equalsIgnoreCase("3D")) {
                boletas3D += f.getNumBoletas();
            }
        }
        
        return boletas35mm >= boletas3D ? "35 mm" : "3D";
    }

    public int getNumero() {
        return numero;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}