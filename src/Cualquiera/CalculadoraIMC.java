package Cualquiera;

import java.util.Scanner;

public class CalculadoraIMC {
    private double altura;
    private double peso;

    public double getAltura() {
        return altura;
    }

    public void setAltura(Scanner sc) {
        System.out.print("Ingrese su altura en m: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            sc.next();
        }
        this.altura = sc.nextDouble();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Scanner sc) {
        System.out.print("Ingrese su peso en kg: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            sc.next();
        }
        this.peso = sc.nextDouble();
    }

    public double IMC() {
        try {
            if (altura <= 0) {
                throw new IllegalArgumentException("La altura debe ser mayor que 0");
            }
            double imc = peso / Math.pow(altura, 2);
            System.out.printf("Su IMC es: %.2f%n", imc);

            if (imc < 18.5) {
                System.out.println("Está bajo de peso.");
            } else if (imc >= 18.5 && imc < 24.9) {
                System.out.println("Tiene un peso normal.");
            } else if (imc >= 25 && imc < 29.9) {
                System.out.println("Tiene sobrepeso.");
            } else {
                System.out.println("Tiene obesidad.");
            }

            return imc;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}

class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculadoraIMC calculadora = new CalculadoraIMC();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nCalculadora de IMC");
            System.out.println("1. Calcular IMC");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    calculadora.setAltura(sc);
                    calculadora.setPeso(sc);
                    calculadora.IMC();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}
