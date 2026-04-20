package modelo;

public class Prestamo {

    private Cliente cliente;
    private Mesa mesa;
    private JuegoMesa juego;

    public Prestamo(Cliente cliente, Mesa mesa, JuegoMesa juego) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.juego = juego;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public JuegoMesa getJuego() {
        return juego;
    }

    public String toString() {
        return "Prestamo Cliente: " + cliente.getNombre() +
                " Mesa: " + mesa.getId() +
                " Juego: " + juego.getNombre();
    }
}