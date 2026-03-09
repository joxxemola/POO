package modelo;

public class Factura {
    private Cliente cliente;
    private String promotora;
    private String tipoFuncion;
    private int numBoletas;

    public Factura(Cliente cliente, String promotora, String tipoFuncion, int numBoletas) {
        this.cliente = cliente;
        this.promotora = promotora;
        this.tipoFuncion = tipoFuncion;
        this.numBoletas = numBoletas;
    }

    public double getValorUnitario() {
        if (promotora.equalsIgnoreCase("Cine Colombia")) {
            return tipoFuncion.equalsIgnoreCase("35 mm") ? 8000 : 9500;
        } else if (promotora.equalsIgnoreCase("Royal Films")) {
            return tipoFuncion.equalsIgnoreCase("35 mm") ? 6500 : 8500;
        }
        return 0;
    }

    public double calcularTotal() {
        double total = numBoletas * getValorUnitario();
        if (cliente.isTieneTarjeta()) {
            total *= 0.9; // 10% de descuento
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPromotora() {
        return promotora;
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public int getNumBoletas() {
        return numBoletas;
    }
}