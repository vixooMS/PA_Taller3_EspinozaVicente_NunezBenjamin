package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public class Administrador extends Empleado {

    private boolean superAdministrador;

    public Administrador(String rut, String contrasenia, String nombre, int remuneracion, boolean superAdministrador) {
        super(rut, contrasenia, nombre, "administrador", remuneracion);
        this.superAdministrador = superAdministrador;
    }

    public boolean isSuperAdministrador() {
        return superAdministrador;
    }

    public void registrarProducto(Producto p) {}

    public void eliminarProducto(String codigo) {}

    public void listarProductos() {}
}
