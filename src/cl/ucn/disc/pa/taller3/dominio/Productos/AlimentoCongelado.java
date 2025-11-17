package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Alimento;

public class AlimentoCongelado extends Alimento {

    private float temperaturaAlmacenamiento;
    private String fechaCongelacion;
    private String tipoAlimento;

    public AlimentoCongelado(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                             String fechaVencimiento, String peso, String origen,
                             float temperaturaAlmacenamiento, String fechaCongelacion, String tipoAlimento) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, fechaVencimiento, peso, origen);
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.fechaCongelacion = fechaCongelacion;
        this.tipoAlimento = tipoAlimento;
    }

    public float getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public String getFechaCongelacion() {
        return fechaCongelacion;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    @Override
    public String toStringSimple() {
        return "Congelado: " + getCodigo() + " - " + getNombre() + "  $" + getPrecio()
                + "  Temp:" + temperaturaAlmacenamiento + "°C  Stock:" + getCantidad();
    }

}
