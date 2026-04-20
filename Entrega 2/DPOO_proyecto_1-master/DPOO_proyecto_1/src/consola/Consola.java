package consola;

import java.util.Scanner;

import logica.SistemaDulcesNDados;
import modelo.Cliente;
import modelo.JuegoMesa;

public class Consola {

    private SistemaDulcesNDados sistema;
    private Scanner lector;

    public Consola() {
        sistema = new SistemaDulcesNDados();
        lector = new Scanner(System.in);
    }

    public void iniciar() {

        System.out.println("Sistema: ");

        System.out.println("Ingrese id del cliente:");
        int id = Integer.parseInt(lector.nextLine());

        System.out.println("Ingrese nombre:");
        String nombre = lector.nextLine();

        Cliente cliente = new Cliente(id, nombre, "login", "pass");
        sistema.agregarCliente(cliente);

        System.out.println("\n Nombre del juego:");
        String nombreJuego = lector.nextLine();

        System.out.println("Cantidad minima de jugadores:");
        int min = Integer.parseInt(lector.nextLine());

        System.out.println("Cantidad maxima de jugadores:");
        int max = Integer.parseInt(lector.nextLine());

        System.out.println("Edad minima:");
        int edad = Integer.parseInt(lector.nextLine());

        JuegoMesa juego = new JuegoMesa(nombreJuego, min, max, edad);
        sistema.agregarJuegoPrestamo(juego);

        System.out.println("\nPersonas en la mesa:");
        int cantidad = Integer.parseInt(lector.nextLine());

        System.out.println("Hay jovenes? ");
        boolean jovencitos = Boolean.parseBoolean(lector.nextLine());

        System.out.println("Hay menores de edad? ");
        boolean menores = Boolean.parseBoolean(lector.nextLine());

        sistema.crearMesa(cantidad, jovencitos, menores);

        sistema.prestarJuego(id, 1, nombreJuego);

        System.out.println("\nPrestamos actuales:");
        sistema.mostrarPrestamos();
    }
}