package Prog2problemas.IntroPoo;

import java.util.Scanner;


class Cuenta {
    Scanner sc = new Scanner(System.in);
    private String titular;
    private double cantidad;

    public String getTitular() {
        return titular;
    }

    public void setTitular() {
        System.out.println("Ingrese nombre del titular");
        this.titular = sc.nextLine();

    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        System.out.println("Ingrese cantidad inicial a la cuenta");
        this.cantidad = sc.nextDouble();
    }

    void ingresar() {
        System.out.println("Ingrese cantidad");
        double cantidadAd = sc.nextDouble();
        if (cantidadAd<=0) {
            System.out.println("Cantidad incoherente, ingrese cantidad positiva");
        }
        this.cantidad+=cantidadAd;
    }

    void retirar() {
        System.out.println("Ingrese cantidad a retirar");
        double cantidadRet = sc.nextDouble();
        if (cantidad-cantidadRet<=0) {
            this.cantidad=0;
        } else {
            cantidad-=cantidadRet;
        }
    }

    @Override
    public String toString() {
        return "Cuenta: "+this.titular+"\n"+"Cantidad: $"+this.cantidad;
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        cuenta.setTitular();
        cuenta.setCantidad();
        cuenta.ingresar();
        cuenta.retirar();
        System.out.println(cuenta);
    }

}


