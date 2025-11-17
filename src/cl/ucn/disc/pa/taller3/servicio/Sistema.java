package cl.ucn.disc.pa.taller3.servicio;
import cl.ucn.disc.pa.taller3.dominio.Empleado;

public interface Sistema {

    Empleado iniciarSesion(String rut, String contrasenia);

    void cerrarSesion();
    void cargarEmpleados();
    void cargarProductos();
    void registrarEmpleado(Empleado administrador, Empleado nuevo);
    boolean existeRut(String rut);
    boolean existeCaja(int numeroCaja);
    void registrarVenta(String rutCajero, String rutCliente, String[] codigos, int[] cantidades);
    void listaProductos();
    void listaEmpleados();
    void listaVentasCajero(String rutCajero);
    void listaVentasTotales();
    void aplicarDescuentoSesion(String rutCajero);
    void verVentasRealizadas(String rutCajero);
}
