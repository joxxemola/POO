package Modelo;

public class Empresa {

    private Sala[] salas;

    public Empresa() {
        salas = new Sala[6];
        for (int i = 0; i < 6; i++) {
            salas[i] = new Sala(i + 1);
        }
    }

    public void agregarFactura(int numSala, Factura factura) {
        salas[numSala - 1].agregarFactura(factura);
    }

    public double totalPorPromotora(String promotora) {

        double total = 0;

        for (Sala sala : salas) {
            for (Factura f : sala.getFacturas()) {
                if (f.getPromotora().equalsIgnoreCase(promotora)) {
                    total += f.getTotal();
                }
            }
        }
        return total;
    }

    public String tipoFuncionMasVendida() {

        int total35 = 0;
        int total3D = 0;

        for (Sala sala : salas) {
            for (Factura f : sala.getFacturas()) {

                if (f.getTipoFuncion().equalsIgnoreCase("35mm")) {
                    total35 += f.getNumeroBoletas();
                } else {
                    total3D += f.getNumeroBoletas();
                }
            }
        }

        return total35 >= total3D ? "35mm" : "3D";
    }
}