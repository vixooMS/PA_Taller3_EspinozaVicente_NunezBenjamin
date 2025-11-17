package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public class ContenedorMinimarket {

    private Empleado[] empleados;
    private int cantidadEmpleados;
    private Producto[] productos;
    private int cantidadProductos;
    private Venta[] ventas;
    private int cantidadVentas;

    public ContenedorMinimarket() {
        empleados = new Empleado[200];
        cantidadEmpleados = 0;
        productos = new Producto[500];
        cantidadProductos = 0;
        ventas = new Venta[10000];
        cantidadVentas = 0;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (empleado == null) return false;
        if (cantidadEmpleados >= empleados.length) return false;
        empleados[cantidadEmpleados++] = empleado;
        return true;
    }

    public Empleado buscarEmpleadoPorRut(String rut) {
        if (rut == null) return null;
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i] != null && empleados[i].getRut().equalsIgnoreCase(rut)) return empleados[i];
        }
        return null;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public Cajero buscarCajeroPorRut(String rut) {
        if (rut == null) return null;
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i] instanceof Cajero && empleados[i].getRut().equalsIgnoreCase(rut)) return (Cajero) empleados[i];
        }
        return null;
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null) return false;
        if (cantidadProductos >= productos.length) return false;
        productos[cantidadProductos++] = producto;
        return true;
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        if (codigo == null) return null;
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i] != null && productos[i].getCodigo().equalsIgnoreCase(codigo)) return productos[i];
        }
        return null;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public boolean agregarVenta(Venta venta) {
        if (venta == null) return false;
        if (cantidadVentas >= ventas.length) return false;
        ventas[cantidadVentas++] = venta;
        return true;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }
}
