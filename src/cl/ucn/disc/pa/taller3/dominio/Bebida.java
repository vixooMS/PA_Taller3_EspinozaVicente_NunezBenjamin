package cl.ucn.disc.pa.taller3.dominio;
/*terminado*/
public abstract class Bebida extends Producto {
    protected double volumenLitros;
    protected int cantidadSellos;
    protected String tipoEnvase;

    public Bebida(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                  double volumenLitros, int cantidadSellos, String tipoEnvase) {
        super(codigo, nombre, precio, marca, cantidad, proveedor);
        if (volumenLitros < 0) throw new IllegalArgumentException("volumen invalido");
        if (cantidadSellos < 0) throw new IllegalArgumentException("cantidadSellos invalido");
        if (tipoEnvase == null) tipoEnvase = "";
        this.volumenLitros = volumenLitros;
        this.cantidadSellos = cantidadSellos;
        this.tipoEnvase = tipoEnvase.trim();
    }

    public double getVolumenLitros() { return volumenLitros; }
    public void setVolumenLitros(double volumenLitros) {
        if (volumenLitros < 0) throw new IllegalArgumentException("volumen invalido");
        this.volumenLitros = volumenLitros;
    }
    public int getCantidadSellos() { return cantidadSellos; }
    public void setCantidadSellos(int cantidadSellos) {
        if (cantidadSellos < 0) throw new IllegalArgumentException("cantidadSellos invalido");
        this.cantidadSellos = cantidadSellos;
    }
    public String getTipoEnvase() { return tipoEnvase; }
    public void setTipoEnvase(String tipoEnvase) { this.tipoEnvase = tipoEnvase == null ? "" : tipoEnvase.trim(); }

    @Override
    public String toString() {
        return super.toString() +
                ", volumenLitros=" + volumenLitros +
                ", cantidadSellos=" + cantidadSellos +
                ", tipoEnvase='" + tipoEnvase + '\'' +
                '}';
    }
}
