package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Alimento;

public class AlimentoPerecedero extends Alimento {

    private String controlRefrigeracion;
    private String fechaEnvasado;
    private String condicionesConservacion;

    public AlimentoPerecedero(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                              String fechaVencimiento, String peso, String origen,
                              String controlRefrigeracion, String fechaEnvasado, String condicionesConservacion) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, fechaVencimiento, peso, origen);
        this.controlRefrigeracion = controlRefrigeracion;
        this.fechaEnvasado = fechaEnvasado;
        this.condicionesConservacion = condicionesConservacion;
    }

    public String getControlRefrigeracion() {
        return controlRefrigeracion;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public String getCondicionesConservacion() {
        return condicionesConservacion;
    }

    @Override
    public String toStringSimple() {
        return "Perecedero: " + getCodigo() + " - " + getNombre() + "  $" + getPrecio()
                + "  Vence: " + fechaVencimiento + "  Stock:" + getCantidad();
    }

}
