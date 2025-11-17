package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public abstract class Empleado {

    protected String rut;
    protected String contrasenia;
    protected String nombre;
    protected String tipoEmpleado;
    protected int remuneracion;

    public Empleado(String rut, String contrasenia, String nombre, String tipoEmpleado, int remuneracion) {
        if (rut == null || rut.trim().isEmpty()) throw new IllegalArgumentException("rut invalido");
        if (contrasenia == null) contrasenia = "";
        if (nombre == null) nombre = "";
        if (tipoEmpleado == null) tipoEmpleado = "";
        if (remuneracion < 0) throw new IllegalArgumentException("remuneracion invalida");
        this.rut = rut.trim();
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.tipoEmpleado = tipoEmpleado;
        this.remuneracion = remuneracion;
    }

    public String getRut() {
        return rut;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public int getRemuneracion() {
        return remuneracion;
    }

    @Override
    public String toString() {
        return tipoEmpleado.toUpperCase() + " {rut='" + rut + "', nombre='" + nombre + "', remuneracion=" + remuneracion + "}";
    }
}
