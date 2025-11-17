package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public class Venta {

    private String rutEmpleado;
    private String rutCliente;
    private String fecha;
    private Producto[] productos;
    private int[] cantidades;
    private int[] montosPorProducto;
    private int cantidadItems;
    private int montoTotal;

    public Venta(String rutEmpleado, String rutCliente, String fecha) {
        this.rutEmpleado = rutEmpleado == null ? "" : rutEmpleado;
        this.rutCliente = rutCliente == null ? "" : rutCliente;
        this.fecha = fecha == null ? "" : fecha;
        this.productos = new Producto[200];
        this.cantidades = new int[200];
        this.montosPorProducto = new int[200];
        this.cantidadItems = 0;
        this.montoTotal = 0;
    }

    public void agregarProducto(Producto p, int cantidad) {
        if (p == null) return;
        if (cantidad <= 0) return;
        if (cantidadItems >= productos.length) return;
        productos[cantidadItems] = p;
        cantidades[cantidadItems] = cantidad;
        montosPorProducto[cantidadItems] = p.getPrecio() * cantidad;
        cantidadItems++;
    }

    public void calcularTotal() {
        int total = 0;
        for (int i = 0; i < cantidadItems; i++) total += montosPorProducto[i];
        montoTotal = total;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public Producto getProducto(int index) {
        if (index < 0 || index >= cantidadItems) return null;
        return productos[index];
    }

    public int getCantidad(int index) {
        if (index < 0 || index >= cantidadItems) return 0;
        return cantidades[index];
    }

    @Override
    public String toString() {
        return "Venta {rutEmpleado='" + rutEmpleado + "', rutCliente='" + rutCliente + "', montoTotal=" + montoTotal + ", fecha='" + fecha + "'}";
    }
}
