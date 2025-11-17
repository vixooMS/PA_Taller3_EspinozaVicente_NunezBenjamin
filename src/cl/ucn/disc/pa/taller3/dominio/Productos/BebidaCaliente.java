package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Bebida;

public class BebidaCaliente extends Bebida {

    private String tipoBebida;
    private String temperaturaServicio;
    private String tamanoEnvase;

    public BebidaCaliente(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                          double volumenLitros, int cantidadSellos, String tipoEnvase,
                          String tipoBebida, String temperaturaServicio, String tamanoEnvase) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, volumenLitros, cantidadSellos, tipoEnvase);
        this.tipoBebida = tipoBebida;
        this.temperaturaServicio = temperaturaServicio;
        this.tamanoEnvase = tamanoEnvase;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public String getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public String getTamanoEnvase() {
        return tamanoEnvase;
    }


    @Override
    public String toStringSimple() {
        return "Caliente: " + getCodigo() + " - " + getNombre() + " (" + tipoBebida + ")  $" + getPrecio()
                + "  " + tamanoEnvase + "  Stock:" + getCantidad();
    }

}
