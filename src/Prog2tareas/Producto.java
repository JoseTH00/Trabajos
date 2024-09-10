package Prog2tareas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Product0 {
    private int codProd, stock;
    private String nombre;

    public Product0(int codProd, int stock, String nombre) {
        this.codProd = codProd;
        this.stock = stock;
        this.nombre = nombre;
    }

    public int getCodProd() {
        return codProd;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product0 product0 = (Product0) o;
        return codProd == product0.codProd;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codProd);
    }

    @Override
    public String toString() {
        return "Product0{" +
                "codProd=" + codProd +
                ", stock=" + stock +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
class Ma1n {
    public static void main(String[] args) {
        Product0 p1 = new Product0(1,100,"Oreo");
        Product0 p2 = new Product0(2,100,"Pepito");
        Product0 p3 = new Product0(1,100,"Toddy");

        Set<Product0> product0s = new HashSet<Product0>();

        product0s.add(p1);
        product0s.add(p2);
        product0s.add(p3);

        if (p1.getCodProd()==(p2.getCodProd())) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        for (Product0 product0 : product0s) {
            System.out.println(product0.hashCode());
        }

        for (Product0 product0 : product0s) {
            System.out.println(product0);
        }
    }
}
