package cl.ucn.disc.pa.taller3.dominio;
/*terminado*/
public abstract class Alimento extends Producto {
    protected String fechaVencimiento;
    protected String peso;
    protected String origen;

    public Alimento(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                    String fechaVencimiento, String peso, String origen) {
        super(codigo, nombre, precio, marca, cantidad, proveedor);
        if (fechaVencimiento == null) fechaVencimiento = "";
        if (peso == null) peso = "";
        if (origen == null) origen = "";
        this.fechaVencimiento = fechaVencimiento.trim();
        this.peso = peso.trim();
        this.origen = origen.trim();
    }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento == null ? "" : fechaVencimiento.trim();
    }
    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso == null ? "" : peso.trim(); }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen == null ? "" : origen.trim(); }

    @Override
    public String toString() {
        return super.toString() +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", peso='" + peso + '\'' +
                ", origen='" + origen + '\'' +
                '}';
    }
}
