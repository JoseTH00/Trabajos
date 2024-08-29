package Prog2problemas.IntroPoo;

import java.util.Scanner;

class Persona {
    Scanner sc = new Scanner(System.in);

    private String nombre, dni;
    private char sexo;
    private int edad;
    private double peso, altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = generaDNI();
        this.sexo = 'H';
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, char sexo, int edad) {
        this.nombre = nombre;
        this.sexo = comprobarSexo(sexo);
        this.edad = edad;
        this.dni = generaDNI();
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, char sexo, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.sexo = comprobarSexo(sexo);
        this.edad = edad;
        this.dni = generaDNI();
        this.peso = peso;
        this.altura = altura;
    }

    public void creacionPersona() {
        setNombre();
        setSexo();
        setEdad();
        this.dni = generaDNI();
        setPeso();
        setAltura();
    }

    public void setNombre() {
        System.out.println("Ingrese su nombre");
        this.nombre = sc.nextLine();
    }

    public void setSexo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese H si es hombre y M si es mujer:");
        String input = sc.nextLine().toUpperCase();

        if (input.length() == 1 && (input.charAt(0) == 'H' || input.charAt(0) == 'M')) {
            this.sexo = input.charAt(0);
        } else {
            this.sexo = 'H';
        }
    }

    public void setEdad() {
        System.out.println("Ingrese su edad");
        this.edad = sc.nextInt();
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPeso() {
        System.out.println("Ingrese su peso");
        this.peso = sc.nextDouble();
    }

    public void setAltura() {
        System.out.println("Ingrese su altura");
        this.altura = sc.nextDouble();
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    double calcularIMC(double peso, double altura) {
        double IMC = peso/(Math.pow(altura,2));

        if (IMC<20) {
            return -1;
        } else if (25>=IMC && IMC>20) {
            return 0;
        } else {
            return 1;
        }

    }

    boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            return 'H';
        }
        return sexo;
    }

    private String generaDNI() {
        int numeroDNI = (int) (Math.random() * 100000000);
        char letraDNI = generaLetraDNI(numeroDNI);
        return String.format("%08d", numeroDNI) + letraDNI;
    }

    private char generaLetraDNI(int numeroDNI) {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[numeroDNI % 23];
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", dni=" + dni +
                ", peso=" + peso +" kg"+
                ", altura=" + altura+" cm";
    }
}
class CreacionDePersonas {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.creacionPersona();

        Persona persona2 = new Persona("Juan", 'H', 25);

        Persona persona3 = new Persona();
        persona3.setNombre();
        persona3.setSexo();
        persona3.setEdad();
        persona3.setPeso();
        persona3.setAltura();

        Persona[] personas = {persona1, persona2, persona3};

        for (Persona persona : personas) {
            double imcResultado = persona.calcularIMC(persona.getPeso(), persona.getAltura());
            String imcMensaje;
            switch ((int) imcResultado) {
                case -1:
                    imcMensaje = "está por debajo del peso ideal.";
                    break;
                case 0:
                    imcMensaje = "está en su peso ideal.";
                    break;
                case 1:
                    imcMensaje = "tiene sobrepeso.";
                    break;
                default:
                    imcMensaje = "tiene un IMC desconocido.";
                    break;
            }
            System.out.println(persona.getNombre() + " " + imcMensaje);

            if (persona.esMayorDeEdad(persona.getEdad())) {
                System.out.println(persona.getNombre() + " es mayor de edad.");
            } else {
                System.out.println(persona.getNombre() + " no es mayor de edad.");
            }

            System.out.println(persona.toString());
            System.out.println();
        }
    }
}

