package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Alimento;

public class AlimentoNoPerecedero extends Alimento {

    private String tiempoAlmacenamientoPermitido;
    private String tipoEnvase;
    private String descripcionProducto;

    public AlimentoNoPerecedero(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                                String fechaVencimiento, String peso, String origen,
                                String tiempoAlmacenamientoPermitido, String tipoEnvase, String descripcionProducto) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, fechaVencimiento, peso, origen);
        this.tiempoAlmacenamientoPermitido = tiempoAlmacenamientoPermitido;
        this.tipoEnvase = tipoEnvase;
        this.descripcionProducto = descripcionProducto;
    }

    public String getTiempoAlmacenamientoPermitido() {
        return tiempoAlmacenamientoPermitido;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    @Override
    public String toStringSimple() {
        return "NoPerec: " + getCodigo() + " - " + getNombre() + "  $" + getPrecio()
                + "  Env: " + tipoEnvase + "  Stock:" + getCantidad();
    }

}
