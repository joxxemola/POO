package Modelo;

import java.util.ArrayList;

public class Sala {

    private int numero;
    private ArrayList<Factura> facturas;

    public Sala(int numero) {
        this.numero = numero;
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
}