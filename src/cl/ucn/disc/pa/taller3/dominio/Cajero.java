package cl.ucn.disc.pa.taller3.dominio;
/*TERMINADO*/
import ucn.StdOut;

public class Cajero extends Empleado {

    private int numeroCaja;
    private int totalDineroRecaudado;
    private Venta[] ventasRealizadas;
    private int cantidadVentasRealizadas;
    private int comisionAcumulada;

    public Cajero(String rut, String contrasenia, String nombre, int remuneracion, int numeroCaja) {
        super(rut, contrasenia, nombre, "cajero", remuneracion);
        if (numeroCaja < 0) numeroCaja = 0;
        this.numeroCaja = numeroCaja;
        this.totalDineroRecaudado = 0;
        this.ventasRealizadas = new Venta[1000];
        this.cantidadVentasRealizadas = 0;
        this.comisionAcumulada = 0;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public int getTotalDineroRecaudado() {
        return totalDineroRecaudado;
    }

    public int getComisionAcumulada() {
        return comisionAcumulada;
    }

    public void setTotalDineroRecaudado(int totalDineroRecaudado) {
        this.totalDineroRecaudado = totalDineroRecaudado;
    }

    public void registrarVenta(Venta venta) {
        if (venta == null) return;
        if (cantidadVentasRealizadas >= ventasRealizadas.length) return;
        ventasRealizadas[cantidadVentasRealizadas] = venta;
        cantidadVentasRealizadas++;
        totalDineroRecaudado += venta.getMontoTotal();
        comisionAcumulada += calcularComision(venta);
    }

    public int calcularComision(Venta venta) {
        if (venta == null) return 0;
        return (int) Math.round(venta.getMontoTotal() * 0.05);
    }

    public void verVentasRealizadas() {
        for (int i = 0; i < cantidadVentasRealizadas; i++) {
            StdOut.println(ventasRealizadas[i]);
        }
    }
}
