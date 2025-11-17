package cl.ucn.disc.pa.taller3.servicio;
import ucn.ArchivoEntrada;
import ucn.Registro;

import cl.ucn.disc.pa.taller3.dominio.*;
import cl.ucn.disc.pa.taller3.dominio.Productos.*;
import ucn.*;

import java.io.IOException;

public class SistemaMinimarket implements Sistema {

    private ContenedorMinimarket contenedor;
    private Empleado usuarioActual;
    private String tipoDescuentoSesion;
    private double porcentajeDescuento;

    public SistemaMinimarket(ContenedorMinimarket contenedor) {
        this.contenedor = contenedor;
        this.usuarioActual = null;
        this.tipoDescuentoSesion = "Ninguno";
        this.porcentajeDescuento = 0.0;
    }

    @Override
    public Empleado iniciarSesion(String rut, String contrasenia) {
        Empleado empleado = contenedor.buscarEmpleadoPorRut(rut);
        if (empleado == null) {
            return null;
        }
        if (!empleado.getContrasenia().equals(contrasenia)) {
            return null;
        }

        usuarioActual = empleado;

        if (empleado instanceof Cajero) {
            aplicarDescuentoSesion(empleado.getRut());
        } else {
            tipoDescuentoSesion = "Ninguno";
            porcentajeDescuento = 0.0;
        }
        return empleado;
    }

    @Override
    public void cerrarSesion() {
        usuarioActual = null;
        tipoDescuentoSesion = "Ninguno";
        porcentajeDescuento = 0.0;
    }

    @Override
    public void cargarEmpleados() {
        try {
            ArchivoEntrada archivo = new ArchivoEntrada("empleados.txt");

            while (!archivo.isEndFile()) {
                Registro linea = archivo.getRegistro();

                String tipo = linea.getString();
                String rut = linea.getString();
                String contrasenia = linea.getString();
                String nombre = linea.getString();
                int remuneracion = linea.getInt();

                Empleado empleado = null;

                if (tipo.equalsIgnoreCase("AD")) {
                    boolean superAdmin = linea.getBoolean();
                    empleado = new Administrador(rut, contrasenia, nombre, remuneracion, superAdmin);
                }

                else if (tipo.equalsIgnoreCase("CA")) {
                    int numeroCaja = linea.getInt();
                    int dineroRecaudado = linea.getInt();

                    Cajero cajero = new Cajero(rut, contrasenia, nombre, remuneracion, numeroCaja);
                    cajero.setTotalDineroRecaudado(dineroRecaudado);
                    empleado = cajero;
                }

                else if (tipo.equalsIgnoreCase("RE")) {
                    String tipoProductoAsignado = linea.getString();
                    int totalRepuesto = linea.getInt();
                    String zona = linea.getString();

                    Reponedor reponedor = new Reponedor(
                            rut, contrasenia, nombre, remuneracion, zona, tipoProductoAsignado
                    );
                    reponedor.setTotalRepuesto(totalRepuesto);
                    empleado = reponedor;
                }

                if (empleado != null) {
                    contenedor.agregarEmpleado(empleado);
                }
            }

            archivo.close();
        } catch (IOException e) {
            StdOut.println("Error al cargar empleados.");
        }
    }



    @Override
    public void cargarProductos() {
        try {
            ArchivoEntrada archivo = new ArchivoEntrada("productos.txt");

            while (!archivo.isEndFile()) {
                Registro linea = archivo.getRegistro();

                String tipo = linea.getString();
                String codigo = linea.getString();
                String nombre = linea.getString();
                int precio = linea.getInt();
                String marca = linea.getString();
                int cantidad = linea.getInt();
                String proveedor = linea.getString();

                Producto producto = null;

                if (tipo.equalsIgnoreCase("BG")) {
                    double volumen = linea.getDouble();
                    int sellos = linea.getInt();
                    String envase = linea.getString();
                    boolean retornable = linea.getBoolean();
                    String nivel = linea.getString();
                    String version = linea.getString();

                    producto = new BebidaGaseosa(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            volumen, sellos, envase, retornable, nivel, version
                    );
                }

                else if (tipo.equalsIgnoreCase("BA")) {
                    double volumen = linea.getDouble();
                    int sellos = linea.getInt();
                    String envase = linea.getString();
                    double grados = linea.getDouble();
                    String origen = linea.getString();
                    String control = linea.getString();

                    producto = new BebidaAlcoholica(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            volumen, sellos, envase, grados, origen, control
                    );
                }

                else if (tipo.equalsIgnoreCase("BC")) {
                    double volumen = linea.getDouble();
                    int sellos = linea.getInt();
                    String envase = linea.getString();
                    String tipoBebida = linea.getString();
                    String temperatura = linea.getString();
                    String tamano = linea.getString();

                    producto = new BebidaCaliente(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            volumen, sellos, envase, tipoBebida, temperatura, tamano
                    );
                }

                else if (tipo.equalsIgnoreCase("AP")) {
                    boolean control = linea.getBoolean();
                    String venc = linea.getString();
                    String conservacion = linea.getString();

                    producto = new AlimentoPerecedero(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            venc, "N/A", "N/A",
                            String.valueOf(control), "N/A", conservacion
                    );
                }

                else if (tipo.equalsIgnoreCase("AN")) {
                    String venc = linea.getString();
                    String peso = linea.getString();
                    String origen = linea.getString();

                    producto = new AlimentoNoPerecedero(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            venc, peso, origen, "N/A", "N/A", "N/A"
                    );
                }

                else if (tipo.equalsIgnoreCase("AC")) {
                    String venc = linea.getString();
                    String peso = linea.getString();
                    String origen = linea.getString();

                    producto = new AlimentoCongelado(
                            codigo, nombre, precio, marca, cantidad, proveedor,
                            venc, peso, origen, 0f, "N/A", "N/A"
                    );
                }

                if (producto != null) {
                    contenedor.agregarProducto(producto);
                }
            }

            archivo.close();
        } catch (IOException e) {
            StdOut.println("Error al cargar productos.");
        }
    }





    @Override
    public void registrarEmpleado(Empleado administrador, Empleado nuevo) {
        if (!(administrador instanceof Administrador)) {
            StdOut.println("Solo un administrador puede registrar empleados.");
            return;
        }

        Administrador admin = (Administrador) administrador;

        if (!admin.isSuperAdministrador()) {
            StdOut.println("Solo un Super Administrador puede registrar empleados.");
            return;
        }

        if (existeRut(nuevo.getRut())) {
            StdOut.println("El rut ya existe.");
            return;
        }

        if (nuevo instanceof Cajero) {
            Cajero caj = (Cajero) nuevo;
            if (existeCaja(caj.getNumeroCaja())) {
                StdOut.println("La caja ya está asignada.");
                return;
            }
        }

        contenedor.agregarEmpleado(nuevo);
    }

    @Override
    public boolean existeRut(String rut) {
        return contenedor.buscarEmpleadoPorRut(rut) != null;
    }

    @Override
    public boolean existeCaja(int numeroCaja) {
        Empleado[] empleados = contenedor.getEmpleados();
        int total = contenedor.getCantidadEmpleados();

        for (int i = 0; i < total; i++) {
            if (empleados[i] instanceof Cajero) {
                Cajero caj = (Cajero) empleados[i];
                if (caj.getNumeroCaja() == numeroCaja) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void registrarVenta(String rutCajero, String rutCliente, String[] codigos, int[] cantidades) {
        Cajero cajero = (Cajero) contenedor.buscarEmpleadoPorRut(rutCajero);

        if (cajero == null) {
            StdOut.println("Cajero no encontrado.");
            return;
        }

        Venta venta = new Venta(rutCajero, rutCliente, "hoy");

        for (int i = 0; i < codigos.length; i++) {
            Producto producto = contenedor.buscarProductoPorCodigo(codigos[i]);

            if (producto == null) {
                StdOut.println("Producto " + codigos[i] + " no encontrado.");
                continue;
            }

            if (cantidades[i] <= 0 || producto.getCantidad() < cantidades[i]) {
                StdOut.println("Stock insuficiente para " + producto.getNombre());
                continue;
            }

            venta.agregarProducto(producto, cantidades[i]);
            producto.setCantidad(producto.getCantidad() - cantidades[i]);
        }

        venta.calcularTotal();
        cajero.registrarVenta(venta);
        contenedor.agregarVenta(venta);
    }

    @Override
    public void listaProductos() {
        Producto[] productos = contenedor.getProductos();
        int total = contenedor.getCantidadProductos();

        for (int i = 0; i < total; i++) {
            StdOut.println(productos[i].toStringSimple());
        }
    }

    @Override
    public void listaEmpleados() {
        Empleado[] empleados = contenedor.getEmpleados();
        int total = contenedor.getCantidadEmpleados();

        for (int i = 0; i < total; i++) {
            StdOut.println(empleados[i]);
        }
    }

    @Override
    public void listaVentasCajero(String rutCajero) {
        Empleado e = contenedor.buscarEmpleadoPorRut(rutCajero);
        if (e instanceof Cajero) {
            ((Cajero) e).verVentasRealizadas();
        }
    }

    @Override
    public void listaVentasTotales() {
        Venta[] ventas = contenedor.getVentas();
        int total = contenedor.getCantidadVentas();

        for (int i = 0; i < total; i++) {
            StdOut.println(ventas[i]);
        }
    }

    @Override
    public void aplicarDescuentoSesion(String rutCajero) {
        tipoDescuentoSesion = "Ninguno";
        porcentajeDescuento = 0.0;
    }

    @Override
    public void verVentasRealizadas(String rutCajero) {
        listaVentasCajero(rutCajero);
    }
}
