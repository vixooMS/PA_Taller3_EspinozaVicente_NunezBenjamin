package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected int precio;
    protected String marca;
    protected int cantidad;
    protected String proveedor;

    public Producto(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
    public String toStringSimple() {
        return codigo + " - " + nombre + " (" + marca + ")  $" + precio + "  Stock: " + cantidad;
    }




}
