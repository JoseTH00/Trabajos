package Prog2tareas;
import java.util.ArrayList;
import java.util.List;

class Persona {
    protected String nombre;
    protected int edad;
    protected String dni;

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}

class EmpleadoSucursal extends Persona {
    protected double sueldo;
    protected int cantidadHoras;

    public EmpleadoSucursal(String nombre, int edad, String dni, double sueldo, int cantidadHoras) {
        super(nombre, edad, dni);
        this.sueldo = sueldo;
        this.cantidadHoras = cantidadHoras;
    }

    public double calcularSueldo() {
        return sueldo * cantidadHoras;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }
}

class Cajero extends EmpleadoSucursal {
    private int numeroCaja;

    public Cajero(String nombre, int edad, String dni, double sueldo, int cantidadHoras, int numeroCaja) {
        super(nombre, edad, dni, sueldo, cantidadHoras);
        this.numeroCaja = numeroCaja;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }
}

class Supervisor extends EmpleadoSucursal {
    private String sector;
    private int personasACargo;

    public Supervisor(String nombre, int edad, String dni, double sueldo, int cantidadHoras, String sector, int personasACargo) {
        super(nombre, edad, dni, sueldo, cantidadHoras);
        this.sector = sector;
        this.personasACargo = personasACargo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getPersonasACargo() {
        return personasACargo;
    }

    public void setPersonasACargo(int personasACargo) {
        this.personasACargo = personasACargo;
    }
}

class Seguridad extends EmpleadoSucursal {
    private String sector;

    public Seguridad(String nombre, int edad, String dni, double sueldo, int cantidadHoras, String sector) {
        super(nombre, edad, dni, sueldo, cantidadHoras);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}

class ClienteSucursal {
    private boolean mayorista;
    private boolean nuevoSocio;

    public ClienteSucursal(boolean mayorista, boolean nuevoSocio) {
        this.mayorista = mayorista;
        this.nuevoSocio = nuevoSocio;
    }

    public boolean isMayorista() {
        return mayorista;
    }

    public void setMayorista(boolean mayorista) {
        this.mayorista = mayorista;
    }

    public boolean isNuevoSocio() {
        return nuevoSocio;
    }

    public void setNuevoSocio(boolean nuevoSocio) {
        this.nuevoSocio = nuevoSocio;
    }
}

class Sucursal {
    private Jefe jefe;
    private List<Cajero> cajeros;
    private List<Supervisor> supervisores;
    private List<Seguridad> seguridad;

    public Sucursal(Jefe jefe) {
        this.jefe = jefe;
        this.cajeros = new ArrayList<>();
        this.supervisores = new ArrayList<>();
        this.seguridad = new ArrayList<>();
    }

    public void agregarCajero(Cajero cajero) {
        cajeros.add(cajero);
    }

    public void agregarSupervisor(Supervisor supervisor) {
        supervisores.add(supervisor);
    }

    public void agregarSeguridad(Seguridad guardia) {
        seguridad.add(guardia);
    }

    public double calcularSueldos() {
        double totalSueldos = 0;
        for (Cajero cajero : cajeros) {
            totalSueldos += cajero.calcularSueldo();
        }
        for (Supervisor supervisor : supervisores) {
            totalSueldos += supervisor.calcularSueldo();
        }
        for (Seguridad guardia : seguridad) {
            totalSueldos += guardia.calcularSueldo();
        }
        return totalSueldos;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }
}

class Jefe extends EmpleadoSucursal {
    public Jefe(String nombre, int edad, String dni, double sueldo, int cantidadHoras) {
        super(nombre, edad, dni, sueldo, cantidadHoras);
    }
}

class Informe {
    public void verSueldo(EmpleadoSucursal empleadoo) {
        System.out.println("Sueldo: " + empleadoo.calcularSueldo());
    }

    public void verParticularidades(EmpleadoSucursal empleado) {
        if (empleado instanceof Cajero) {
            System.out.println("Número de Caja: " + ((Cajero) empleado).getNumeroCaja());
        } else if (empleado instanceof Supervisor) {
            System.out.println("Sector: " + ((Supervisor) empleado).getSector());
            System.out.println("Personas a Cargo: " + ((Supervisor) empleado).getPersonasACargo());
        } else if (empleado instanceof Seguridad) {
            System.out.println("Sector: " + ((Seguridad) empleado).getSector());
        }
    }
}

class Main {
    public static void main(String[] args) {
        Jefe jefe = new Jefe("Carlos", 50, "12345678", 5000, 40);
        Sucursal sucursal = new Sucursal(jefe);

        Cajero cajero1 = new Cajero("Ana", 30, "87654321", 2000, 40, 1);
        Supervisor supervisor1 = new Supervisor("Juan", 40, "11223344", 3000, 40, "Ventas", 5);
        Seguridad seguridad1 = new Seguridad("Pedro", 35, "99887766", 1500, 40, "Acceso");

        sucursal.agregarCajero(cajero1);
        sucursal.agregarSupervisor(supervisor1);
        sucursal.agregarSeguridad(seguridad1);

        Informe informe = new Informe();
        informe.verSueldo(cajero1);
        informe.verParticularidades(supervisor1);

        double totalSueldos = sucursal.calcularSueldos();
        System.out.println("Total de sueldos: " + totalSueldos);
    }
}

