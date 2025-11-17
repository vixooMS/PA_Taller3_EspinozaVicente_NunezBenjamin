package cl.ucn.disc.pa.taller3.dominio.Productos;
/*TERMINADO*/
import cl.ucn.disc.pa.taller3.dominio.Bebida;

public class BebidaAlcoholica extends Bebida {

    private double gradosAlcohol;
    private String paisOrigen;
    private String controlEdad;

    public BebidaAlcoholica(String codigo, String nombre, int precio, String marca, int cantidad, String proveedor,
                            double volumenLitros, int cantidadSellos, String tipoEnvase,
                            double gradosAlcohol, String paisOrigen, String controlEdad) {

        super(codigo, nombre, precio, marca, cantidad, proveedor, volumenLitros, cantidadSellos, tipoEnvase);
        this.gradosAlcohol = gradosAlcohol;
        this.paisOrigen = paisOrigen;
        this.controlEdad = controlEdad;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getControlEdad() {
        return controlEdad;
    }

    @Override
    public String toStringSimple() {
        return "Alcohol: " + getCodigo() + " - " + getNombre() + " (" + getMarca() + ")  $" + getPrecio()
                + "  " + gradosAlcohol + "%  Stock:" + getCantidad();
    }

}
