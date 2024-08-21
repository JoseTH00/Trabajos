package Prog2problemas.IntroPoo;

import java.util.Random;
import java.util.Scanner;

class Libro {
    private long ISBN;
    private int paginas;
    private String titulo, autor;
    Scanner sc = new Scanner(System.in);

    public long getISBN() {
        return ISBN;
    }

    public void setISBN() {
        Random random = new Random();
        long min = 1000000000000L;
        long max = 9999999999999L;
        this.ISBN = min + ((long)(random.nextDouble() * (max - min)));
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas() {
        System.out.println("Ingrese cuántas páginas tiene el libro");
        this.paginas = sc.nextInt();
        sc.nextLine();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo() {
        System.out.println("Ingrese título del libro");
        this.titulo = sc.nextLine();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor() {
        System.out.println("Ingrese quién es el autor");
        this.autor = sc.nextLine();
    }

    public void crearLibro() {
        setISBN();
        setPaginas();
        setTitulo();
        setAutor();
        System.out.println(toString());
        System.out.println("----------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "El libro " + titulo + " con ISBN " + ISBN + ", creado por el autor " + autor + " tiene " + paginas + " páginas.";
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();

        libro1.crearLibro();
        libro2.crearLibro();

        if (libro1.getPaginas() > libro2.getPaginas()) {
            System.out.println("El libro " + libro1.getTitulo() + " tiene más páginas que el libro " + libro2.getTitulo());
        } else if (libro2.getPaginas() > libro1.getPaginas()) {
            System.out.println("El libro " + libro2.getTitulo() + " tiene más páginas que el libro " + libro1.getTitulo());
        } else {
            System.out.println("Ambos libros tienen la misma cantidad de páginas");
        }
    }
}



