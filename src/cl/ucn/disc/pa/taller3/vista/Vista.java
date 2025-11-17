package cl.ucn.disc.pa.taller3.vista;
/*terminado*/
import cl.ucn.disc.pa.taller3.servicio.Sistema;
import cl.ucn.disc.pa.taller3.dominio.Empleado;
import ucn.*;

public class Vista {

    private Sistema sistema;

    public Vista(Sistema sistema) {
        this.sistema = sistema;
    }

    public void inicio() {

        StdOut.println("=====================================");
        StdOut.println("      SISTEMA DE MINIMARKET UCN      ");
        StdOut.println("=====================================");

        while (true) {
            StdOut.println("\n1) Iniciar sesión");
            StdOut.println("2) Listar productos");
            StdOut.println("3) Listar empleados");
            StdOut.println("4) Salir del sistema");
            StdOut.print("Seleccione una opción: ");

            String opcion = StdIn.readLine();

            switch (opcion) {
                case "1":
                    iniciarSesion();
                    break;
                case "2":
                    StdOut.println("---LISTA DE PRODUCTOS---");
                    sistema.listaProductos();
                    break;
                case "3":
                    sistema.listaEmpleados();
                    break;
                case "4":
                    StdOut.println("Cerrando sistema. ¡Hasta luego!");
                    return;

                default:
                    StdOut.println("Opcion invalida. Intente nuevamente.\n");
            }
        }
    }

    private void iniciarSesion() {
        StdOut.print("Ingrese rut: ");
        String rut = StdIn.readLine();

        StdOut.print("Ingrese contraseña: ");
        String contrasenia = StdIn.readLine();

        Empleado empleado = sistema.iniciarSesion(rut, contrasenia);

        if (empleado == null) {
            StdOut.println("ERROR: credenciales incorrectas o usuario no encontrado.");
            return;
        }

        StdOut.println("Sesion iniciada como: " + empleado.getNombre());

        if (empleado.getClass().getSimpleName().equals("Cajero")) {
            menuCajero(empleado);
        } else {
            menuAdministrador(empleado);
        }
    }

    private void menuCajero(Empleado cajero) {
        while (true) {
            StdOut.println("\n--- Menu Cajero ---");
            StdOut.println("1) Registrar venta");
            StdOut.println("2) Ver mis ventas");
            StdOut.println("3) Cerrar sesion");
            StdOut.print("Seleccione una opcion: ");

            String opcion = StdIn.readLine();

            switch (opcion) {
                case "1":
                    registrarVentaVista(cajero);
                    break;
                case "2":
                    sistema.verVentasRealizadas(cajero.getRut());
                    break;
                case "3":
                    StdOut.println("Sesion cerrada.");
                    return;

                default:
                    StdOut.println("Opcion invalida.");
            }
        }
    }

    private void menuAdministrador(Empleado admin) {
        while (true) {
            StdOut.println("\n--- Menu Administrador ---");
            StdOut.println("1) Registrar empleado");
            StdOut.println("2) Ver todas las ventas");
            StdOut.println("3) Cerrar sesion");
            StdOut.print("Seleccione una opcion: ");

            String opcion = StdIn.readLine();

            switch (opcion) {
                case "1":
                    registrarEmpleadoVista(admin);
                    break;
                case "2":
                    sistema.listaVentasTotales();
                    break;
                case "3":
                    StdOut.println("Sesion cerrada.");
                    return;

                default:
                    StdOut.println("Opcion invalida.");
            }
        }
    }

    private void registrarVentaVista(Empleado cajero) {
        StdOut.print("Rut del cliente: ");
        String rutCliente = StdIn.readLine();

        StdOut.print("Cantidad de productos diferentes: ");
        int n = Integer.parseInt(StdIn.readLine());

        String[] codigos = new String[n];
        int[] cantidades = new int[n];

        for (int i = 0; i < n; i++) {
            StdOut.print("Codigo producto " + (i + 1) + ": ");
            codigos[i] = StdIn.readLine();

            StdOut.print("Cantidad: ");
            cantidades[i] = Integer.parseInt(StdIn.readLine());
        }

        sistema.registrarVenta(cajero.getRut(), rutCliente, codigos, cantidades);
    }

    private void registrarEmpleadoVista(Empleado admin) {
        StdOut.print("Rut del nuevo empleado: ");
        String rut = StdIn.readLine();

        StdOut.print("Nombre: ");
        String nombre = StdIn.readLine();

        StdOut.print("Contraseña: ");
        String contrasenia = StdIn.readLine();

        StdOut.print("Remuneracion: ");
        int remuneracion = Integer.parseInt(StdIn.readLine());

        StdOut.print("Tipo (1 = Administrador, 2 = Cajero): ");
        String tipo = StdIn.readLine();

        Empleado nuevo = null;

        if (tipo.equals("1")) {
            nuevo = new cl.ucn.disc.pa.taller3.dominio.Administrador(rut, contrasenia, nombre, remuneracion, false);
        } else if (tipo.equals("2")) {
            StdOut.print("Numero de caja: ");
            int caja = Integer.parseInt(StdIn.readLine());
            nuevo = new cl.ucn.disc.pa.taller3.dominio.Cajero(rut, contrasenia, nombre, remuneracion, caja);
        } else {
            StdOut.println("Tipo invalido.");
            return;
        }
    }
}