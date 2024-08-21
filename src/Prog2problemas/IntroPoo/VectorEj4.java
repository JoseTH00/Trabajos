package Prog2problemas.IntroPoo;

import java.util.Scanner;

class Vector {
    Scanner sc = new Scanner(System.in);
    private double[] coordenadas;

    public Vector(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coordenadas.length; i++) {
            sb.append(coordenadas[i]);
            if (i < coordenadas.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Vector multiplicar() {
        System.out.println("Ingrese numero para multiplicar el vector");
        double numero = sc.nextDouble();
        double[] nuevasCoordenadas = new double[coordenadas.length];
        for (int i = 0; i < coordenadas.length; i++) {
            nuevasCoordenadas[i] = coordenadas[i] * numero;
        }
        return new Vector(nuevasCoordenadas);
    }

    public Vector sumar(Vector otro) {
        if (this.coordenadas.length != otro.coordenadas.length) {
            System.out.println("Error: Los vectores no tienen la misma cantidad de elementos.");
            return otro;
        }
        double[] nuevasCoordenadas = new double[coordenadas.length];
        for (int i = 0; i < coordenadas.length; i++) {
            nuevasCoordenadas[i] = this.coordenadas[i] + otro.coordenadas[i];
        }
        return new Vector(nuevasCoordenadas);
    }

    public static Vector crearVectorDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        double[] elementos = new double[3];

        System.out.print("Introduce el valor de x: ");
        elementos[0] = scanner.nextDouble();

        System.out.print("Introduce el valor de y: ");
        elementos[1] = scanner.nextDouble();

        System.out.print("Introduce el valor de z: ");
        elementos[2] = scanner.nextDouble();

        return new Vector(elementos);
    }

    public static void main(String[] args) {
        Vector v1 = crearVectorDesdeConsola();

        System.out.println("Vector 1: " + v1);

        Vector v2 = v1.multiplicar();
        System.out.println("Vector 1 multiplicado: " + v2);

        Vector v3 = crearVectorDesdeConsola();
        Vector v4 = v1.sumar(v3);
        System.out.println("Suma de "+v1+" y "+v3+" = " + v4);
    }
}

