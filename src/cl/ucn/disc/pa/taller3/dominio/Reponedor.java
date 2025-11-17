package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
public class Reponedor extends Empleado {

    private String zona;
    private String tipoProductoAsignado;
    private int totalRepuesto;

    public Reponedor(String rut, String contrasenia, String nombre, int remuneracion, String zona, String tipoProductoAsignado) {
        super(rut, contrasenia, nombre, "reponedor", remuneracion);
        this.zona = zona == null ? "" : zona;
        this.tipoProductoAsignado = tipoProductoAsignado == null ? "" : tipoProductoAsignado;
        this.totalRepuesto = 0;
    }

    public String getZona() {
        return zona;
    }

    public String getTipoProductoAsignado() {
        return tipoProductoAsignado;
    }

    public int getTotalRepuesto() {
        return totalRepuesto;
    }

    public void setTotalRepuesto(int totalRepuesto) {
        if (totalRepuesto < 0) return;
        this.totalRepuesto = totalRepuesto;
    }

    public void agregarRepuesto(int cantidad) {
        if (cantidad <= 0) return;
        this.totalRepuesto += cantidad;
    }
}
