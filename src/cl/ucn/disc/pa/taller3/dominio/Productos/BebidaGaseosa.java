package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Bebida;

public class BebidaGaseosa extends Bebida {

    private boolean retornable;
    private String nivelAzucar;
    private String version;

    public BebidaGaseosa(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                         double volumenLitros, int cantidadSellos, String tipoEnvase,
                         boolean retornable, String nivelAzucar, String version) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, volumenLitros, cantidadSellos, tipoEnvase);
        this.retornable = retornable;
        this.nivelAzucar = nivelAzucar;
        this.version = version;
    }

    public boolean isRetornable() {
        return retornable;
    }

    public String getNivelAzucar() {
        return nivelAzucar;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toStringSimple() {
        return "Gaseosa: " + getCodigo() + " - " + getNombre() + " (" + getMarca() + ")  $" + getPrecio()
                + "  " + getVolumenLitros() + "L " + version + "  Stock:" + getCantidad();
    }

}
