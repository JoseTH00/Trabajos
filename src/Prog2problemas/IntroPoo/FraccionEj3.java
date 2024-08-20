package Prog2problemas.IntroPoo;

import java.util.Scanner;

class Fraccion {
    private int dividendo;
    private int divisor;

    Scanner sc = new Scanner(System.in);

    public Fraccion() {
    }

    public Fraccion(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        this.dividendo = dividendo;
        this.divisor = divisor;
        simplificar();
    }

    public int getDividendo() {
        return dividendo;
    }

    public void setDividendo() {
        System.out.println("Ingrese dividendo");
        this.dividendo = sc.nextInt();
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor() {
        System.out.println("Ingrese divisor");
        this.divisor = sc.nextInt();
    }

    public void crearFraccion() {
        setDividendo();
        setDivisor();
    }

    public Fraccion sumar(Fraccion otra) {
        int nuevoDividendo = this.dividendo * otra.divisor + otra.dividendo * this.divisor;
        int nuevoDivisor = this.divisor * otra.divisor;
        return new Fraccion(nuevoDividendo, nuevoDivisor);
    }

    public Fraccion multiplicar(Fraccion otra) {
        int nuevoDividendo = this.dividendo * otra.dividendo;
        int nuevoDivisor = this.divisor * otra.divisor;
        return new Fraccion(nuevoDividendo, nuevoDivisor);
    }

    private void simplificar() {
        int gcd = gcd(dividendo, divisor);
        dividendo /= gcd;
        divisor /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return dividendo + "/" + divisor;
    }

    public static void main(String[] args) {
        Fraccion fraccion1 = new Fraccion();
        Fraccion fraccion2 = new Fraccion();

        fraccion1.crearFraccion();
        fraccion2.crearFraccion();

        Fraccion suma = fraccion1.sumar(fraccion2);
        Fraccion producto = fraccion1.multiplicar(fraccion2);

        System.out.println("Suma: " + suma);
        System.out.println("Producto: " + producto);
    }
}

