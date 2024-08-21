package Prog2problemas.IntroPoo;

import java.util.Scanner;

class Papel {
    private String texto;

    public Papel() {
        this.texto = "";
    }

    public void escribir(String cadena) {
        this.texto += cadena;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}

class Birome {
    private int cantidadDeTinta;

    public Birome(int cantidadDeTinta) {
        this.cantidadDeTinta = cantidadDeTinta;
    }

    public void escribir(String texto, Papel papel) {
        int caracteresAEscribir = Math.min(texto.length(), cantidadDeTinta);
        String textoAEscribir = texto.substring(0, caracteresAEscribir);

        papel.escribir(textoAEscribir);
        cantidadDeTinta -= caracteresAEscribir;

        if (cantidadDeTinta == 0) {
            System.out.println("Error: La tinta se ha acabado.");
        }
    }
}

class Escritura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de tinta: ");
        int cantidadDeTinta = sc.nextInt();
        sc.nextLine();

        Birome birome = new Birome(cantidadDeTinta);
        Papel papel = new Papel();

        System.out.print("Ingrese el texto a escribir: ");
        String texto = sc.nextLine();

        birome.escribir(texto, papel);
        System.out.println("Contenido del papel: " + papel);

        sc.close();
    }
}


