package modelo;

public class Empleado extends Usuario {

    private String codigoDescuento;
    private String turno;

    public Empleado(int id, String nombre, String login, String password, String codigoDescuento, String turno) {
        super(id, nombre, login, password);
        this.codigoDescuento = codigoDescuento;
        this.turno = turno;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String toString() {
        return "Empleado: " + getNombre() + " Turno: " + turno;
    }
}
