package Prog2problemas.IntroPoo;

import java.util.Random;
import java.util.Scanner;

class Password {
    private int longitud;
    private String contraseña;

    public Password() {
        this.longitud = 8;
        this.contraseña = generarPassword();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarPassword();
    }

    public boolean esFuerte() {
        int mayusculas = 0, minusculas = 0, numeros = 0;
        for (int i = 0; i < contraseña.length(); i++) {
            char caracter = contraseña.charAt(i);
            if (Character.isUpperCase(caracter)) {
                mayusculas++;
            } else if (Character.isLowerCase(caracter)) {
                minusculas++;
            } else if (Character.isDigit(caracter)) {
                numeros++;
            }
        }
        return (mayusculas > 2 && minusculas > 1 && numeros > 5);
    }

    private String generarPassword() {
        Random rand = new Random();
        StringBuilder nuevaContraseña = new StringBuilder(this.longitud);
        for (int i = 0; i < this.longitud; i++) {
            int tipoCaracter = rand.nextInt(3);
            if (tipoCaracter == 0) {
                nuevaContraseña.append((char) (rand.nextInt(10) + '0'));
            } else if (tipoCaracter == 1) {
                nuevaContraseña.append((char) (rand.nextInt(26) + 'a'));
            } else {
                nuevaContraseña.append((char) (rand.nextInt(26) + 'A'));
            }
        }
        return nuevaContraseña.toString();
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarPassword();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Indica el tamaño del array de Passwords: ");
        int tamaño = scanner.nextInt();

        System.out.print("Indica la longitud de los Passwords: ");
        int longitud = scanner.nextInt();

        Password[] passwords = new Password[tamaño];
        boolean[] esFuerteArray = new boolean[tamaño];

        for (int i = 0; i < tamaño; i++) {
            passwords[i] = new Password(longitud);
            esFuerteArray[i] = passwords[i].esFuerte();
        }

        for (int i = 0; i < tamaño; i++) {
            System.out.println(passwords[i].getContraseña() + " " + esFuerteArray[i]);
        }

        scanner.close();
    }
}

