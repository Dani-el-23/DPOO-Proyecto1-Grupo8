package modelo;

public class Mesa {

    private int id;
    private int cantidad;
    private boolean tieneJovencitos;
    private boolean tieneMenores;

    public Mesa(int id, int cantidad, boolean tieneJovencitos, boolean tieneMenores) {
        this.id = id;
        this.cantidad = cantidad;
        this.tieneJovencitos = tieneJovencitos;
        this.tieneMenores = tieneMenores;
    }

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean tieneJovencitos() {
        return tieneJovencitos;
    }

    public boolean tieneMenores() {
        return tieneMenores;
    }

    public String toString() {
        return "Mesa " + id +
                " Cantidad: " + cantidad +
                " Tiene jovencitos: " + tieneJovencitos +
                " Tiene menores: " + tieneMenores;
    }
}
