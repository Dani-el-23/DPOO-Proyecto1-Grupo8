package modelo;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private int puntosFidelidad;
    private ArrayList<String> historialCompras;

    public Cliente(int id, String nombre, String login, String password) {
        super(id, nombre, login, password);
        this.puntosFidelidad = 0;
        this.historialCompras = new ArrayList<String>();
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public ArrayList<String> getHistorialCompras() {
        return historialCompras;
    }

    public void acumularPuntos(int puntos) {
        puntosFidelidad += puntos;
    }

    public void agregarCompra(String compra) {
        historialCompras.add(compra);
    }

    public String toString() {
        return "Cliente: " + getNombre() + "Puntos: " + puntosFidelidad;
    }
}
