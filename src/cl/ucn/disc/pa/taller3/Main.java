package cl.ucn.disc.pa.taller3;

import cl.ucn.disc.pa.taller3.dominio.ContenedorMinimarket;
import cl.ucn.disc.pa.taller3.servicio.Sistema;
import cl.ucn.disc.pa.taller3.servicio.SistemaMinimarket;
import cl.ucn.disc.pa.taller3.vista.Vista;

public class Main {

    public static void main(String[] args) {

        // contenedor principal
        ContenedorMinimarket contenedor = new ContenedorMinimarket();

        // Crear sistema (servicios)
        Sistema sistema = new SistemaMinimarket(contenedor);


        sistema.cargarEmpleados();
        sistema.cargarProductos();

        // Crear vista
        Vista vista = new Vista(sistema);

        // Iniciar el programa
        vista.inicio();
    }
}
