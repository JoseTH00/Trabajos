package Prog2tareas;
import java.util.ArrayList;
import java.util.List;


class Humane {

    private final String nombre;
    private final String apellido;
    private final int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }
}


class Empleado extends Humane {

    private final double sueldo;

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSueldo: " + this.sueldo;
    }
}


class Caja {
    private final Empleado empleado;
    private final int nroCaja;

    public Caja(Empleado empleado, int nroCaja) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
    }

    @Override
    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }
}


class Cliente extends Humane {

    private final boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }

    public boolean isMayorista() {
        return mayorista;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMayorista: " + this.mayorista;
    }
}


class Producto {
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularTotal() {
        return precio * cantidad;
    }

    @Override
    public String toString() {
        return nombre + " x" + cantidad + " - $" + precio + " cada uno";
    }
}


class Transaccion {
    private final Cliente cliente;
    private final Caja caja;
    private final List<Producto> productos;
    private double total;

    public Transaccion(Cliente cliente, Caja caja) {
        this.cliente = cliente;
        this.caja = caja;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.calcularTotal();
    }

    public double calcularTotalConDescuento() {
        if (cliente.isMayorista()) {
            return total * 0.9;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente:").append("\n").append(cliente.toString()).append("\n");
        sb.append("\n").append("Atendido por: ").append("\n").append(caja.toString()).append("\n");
        sb.append("\n").append("Productos comprados:\n");
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\n").append("Total a pagar: $").append(calcularTotalConDescuento()).append("\n");
        sb.append("\n").append("--------------------").append("\n");

        return sb.toString();
    }
}


public class Supermercado {

    public static void main(String[] args) {


        Empleado empleado1 = new Empleado("Juan", "Pérez", 12345678, 50000);
        Caja caja1 = new Caja(empleado1, 1);


        Cliente cliente1 = new Cliente("Ana", "García", 87654321, true);


        Producto prod1 = new Producto("Pan", 1.5, 10);
        Producto prod2 = new Producto("Leche", 2.0, 5);
        Producto prod3 = new Producto("Huevos", 3.5, 2);


        Transaccion transaccion1 = new Transaccion(cliente1, caja1);
        transaccion1.agregarProducto(prod1);
        transaccion1.agregarProducto(prod2);
        transaccion1.agregarProducto(prod3);


        System.out.println(transaccion1);

        Empleado empleado2 = new Empleado("Cirilo", "Rodriguez", 12345678, 50000);
        Caja caja2 = new Caja(empleado2, 1);


        Cliente cliente = new Cliente("Timoteo", "Datwo", 87654321, false);


        Producto prod4 = new Producto("Harina de trigo", 3.5, 1);
        Producto prod5 = new Producto("Agua", 2.0, 1);
        Producto prod6 = new Producto("Levadura", 1.5, 1);
        Producto prod7 = new Producto("Sal", 2.0, 1);
        Producto prod8 = new Producto("Azucar", 2.5, 1);
        Producto prod9 = new Producto("Mantequilla", 4.0, 1);


        Transaccion transaccion2 = new Transaccion(cliente, caja2);
        transaccion2.agregarProducto(prod4);
        transaccion2.agregarProducto(prod5);
        transaccion2.agregarProducto(prod6);
        transaccion2.agregarProducto(prod7);
        transaccion2.agregarProducto(prod8);
        transaccion2.agregarProducto(prod9);


        System.out.println(transaccion2);
    }
}

