package logica;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.InventarioPrestamosJuego;
import modelo.JuegoMesa;
import modelo.Mesa;
import modelo.Prestamo;

public class SistemaDulcesNDados {

    private ArrayList<Cliente> clientes;
    private ArrayList<Mesa> mesas;
    private ArrayList<Prestamo> prestamos;
    private InventarioPrestamosJuego inventarioPrestamosJuego;

    public SistemaDulcesNDados() {
        clientes = new ArrayList<Cliente>();
        mesas = new ArrayList<Mesa>();
        prestamos = new ArrayList<Prestamo>();
        inventarioPrestamosJuego = new InventarioPrestamosJuego();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarJuegoPrestamo(JuegoMesa juego) {
        inventarioPrestamosJuego.agregarJuego(juego);
    }

    public void mostrarJuegos() {
        inventarioPrestamosJuego.mostrarJuegos();
    }

    public void crearMesa(int cantidad, boolean tieneJovencitos, boolean tieneMenores) {
        int nuevoId = mesas.size() + 1;
        Mesa nuevaMesa = new Mesa(nuevoId, cantidad, tieneJovencitos, tieneMenores);
        mesas.add(nuevaMesa);

        System.out.println("Mesa creada correctamente con id " + nuevoId);
    }

    public void mostrarMesas() {
        if (mesas.size() == 0) {
            System.out.println("No hay mesas registradas");
        } 
        else {
            for (int i = 0; i < mesas.size(); i++) {
                System.out.println(mesas.get(i));
            }
        }
    }

    public Cliente buscarCliente(int idCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual = clientes.get(i);

            if (clienteActual.getId() == idCliente) {
                return clienteActual;
            }
        }
        return null;
    }

    public Mesa buscarMesa(int idMesa) {
        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaActual = mesas.get(i);

            if (mesaActual.getId() == idMesa) {
                return mesaActual;
            }
        }
        return null;
    }

    public Prestamo buscarPrestamoPorJuego(String nombreJuego) {
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamoActual = prestamos.get(i);

            if (prestamoActual.getJuego().getNombre().equalsIgnoreCase(nombreJuego)) {
                return prestamoActual;
            }
        }
        return null;
    }

    public int contarPrestamosActivosCliente(int idCliente) {
        int cantidadPrestamos = 0;

        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamoActual = prestamos.get(i);

            if (prestamoActual.getCliente().getId() == idCliente &&
                !prestamoActual.getJuego().estaDisponible()) {
                cantidadPrestamos++;
            }
        }

        return cantidadPrestamos;
    }

    public void prestarJuego(int idCliente, int idMesa, String nombreJuego) {
        Cliente cliente = buscarCliente(idCliente);
        Mesa mesa = buscarMesa(idMesa);
        JuegoMesa juego = inventarioPrestamosJuego.buscarJuego(nombreJuego);

        if (cliente == null) {
            System.out.println("No hay ningun cliente");
            return;
        }

        if (mesa == null) {
            System.out.println("No hay ninguna mesa");
            return;
        }

        if (juego == null) {
            System.out.println("No hay ningun juego");
            return;
        }

        if (!juego.estaDisponible()) {
            System.out.println("No esta el juego disponible en este momento");
            return;
        }

        if (!juego.esAdecuadoParaMesa(mesa)) {
            System.out.println("El juego no se puede usar");
            return;
        }

        if (contarPrestamosActivosCliente(idCliente) >= 2) {
            System.out.println("Ya se le presto el maximo de juegos al cliente");
            return;
        }

        Prestamo nuevoPrestamo = new Prestamo(cliente, mesa, juego);
        prestamos.add(nuevoPrestamo);
        juego.registrarPrestamo();

        System.out.println("Se ha hecho el prestamo correctamente");
    }

    public void devolverJuego(String nombreJuego) {
        Prestamo prestamo = buscarPrestamoPorJuego(nombreJuego);

        if (prestamo == null) {
            System.out.println("No hay un prestamos relacionado con el juego");
            return;
        }

        JuegoMesa juego = prestamo.getJuego();

        if (juego.estaDisponible()) {
            System.out.println("Esta disponible");
            return;
        }

        juego.registrarDevolucion();
        System.out.println("Se ha devuelto correctamente");
    }

    public void mostrarPrestamos() {
        if (prestamos.size() == 0) {
            System.out.println("No hay ningun prestamo registrados");
        } 
        else {
            for (int i = 0; i < prestamos.size(); i++) {
                System.out.println(prestamos.get(i));
            }
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public InventarioPrestamosJuego getInventarioPrestamosJuego() {
        return inventarioPrestamosJuego;
    }
}