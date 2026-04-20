package modelo;

import java.util.ArrayList;

public class InventarioPrestamosJuego {

    private ArrayList<JuegoMesa> juegos;

    public InventarioPrestamosJuego() {
        juegos = new ArrayList<JuegoMesa>();
    }

    public ArrayList<JuegoMesa> getJuegos() {
        return juegos;
    }

    public void agregarJuego(JuegoMesa juego) {
        juegos.add(juego);
    }

    public JuegoMesa buscarJuego(String nombre) {
        for (int i = 0; i < juegos.size(); i++) {
            JuegoMesa juego = juegos.get(i);
            if (juego.getNombre().equalsIgnoreCase(nombre)) {
                return juego;
            }
        }
        return null;
    }

    public void mostrarJuegos() {
        for (int i = 0; i < juegos.size(); i++) {
            System.out.println(juegos.get(i));
        }
    }
}