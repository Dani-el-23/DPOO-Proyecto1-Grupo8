package modelo;

import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nombre;
    private String login;
    private String password;
    private ArrayList<JuegoMesa> juegosFavoritos;

    public Usuario(int id, String nombre, String login, String password) {
        this.id = id;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.juegosFavoritos = new ArrayList<JuegoMesa>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<JuegoMesa> getJuegosFavoritos() {
        return juegosFavoritos;
    }

    public void agregarJuegoFavorito(JuegoMesa juego) {
        juegosFavoritos.add(juego);
    }

    public boolean validarLogin(String loginIngresado, String passwordIngresado) {
        return login.equals(loginIngresado) && password.equals(passwordIngresado);
    }

    public String toString() {
        return "Usuario: " + nombre + " - Login: " + login;
    }
}
