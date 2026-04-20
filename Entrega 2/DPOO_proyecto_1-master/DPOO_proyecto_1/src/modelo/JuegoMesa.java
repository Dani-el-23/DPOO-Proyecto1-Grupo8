package modelo;

public class JuegoMesa {

    // Nos dimos cuenta que algunos atributos no eran completamente necesarios por lo que los excluimos.
    private String nombre;
    private int cantidadMinima;
    private int cantidadMaxima;
    private int edadMinima;
    private boolean estaDisponible;

    public JuegoMesa(String nombre, int cantidadMinima, int cantidadMaxima, int edadMinima) {
        this.nombre = nombre;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
        this.edadMinima = edadMinima;
        this.estaDisponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public boolean estaDisponible() {
        return estaDisponible;
    }

    public void registrarPrestamo() {
        estaDisponible = false;
    }

    public void registrarDevolucion() {
        estaDisponible = true;
    }

    public boolean esAdecuadoParaMesa(Mesa mesa) {

        boolean cantidadJugadoresValida =
                mesa.getCantidad() >= cantidadMinima &&
                mesa.getCantidad() <= cantidadMaxima;

        boolean edadValida = true;

        if (mesa.tieneJovencitos() && edadMinima > 5) {
            edadValida = false;
        }

        if (mesa.tieneMenores() && edadMinima >= 18) {
            edadValida = false;
        }

        return cantidadJugadoresValida && edadValida;
    }

    public String toString() {
        return nombre +
                " Jugadores: " + cantidadMinima + " " + cantidadMaxima +
                " Edad mínima: " + edadMinima +
                " Disponible: " + estaDisponible;
    }
}