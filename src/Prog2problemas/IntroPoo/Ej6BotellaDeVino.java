package Prog2problemas.IntroPoo;

import java.util.Scanner;

class Corcho {
    Scanner sc = new Scanner(System.in);
    private String bodega;
    private boolean enBotella;

    Corcho() {
        System.out.println("Ingrese el nombre de la bodega");
        this.bodega = sc.nextLine();
        this.enBotella = true;
    }

    String getBodega() {
        return bodega;
    }

    boolean isEnBotella() {
        return enBotella;
    }

    void sacarDeBotella() {
        this.enBotella = false;
    }
}

class Botella {
    private Corcho corcho;

    Botella(Corcho corcho) {
        this.corcho = corcho;
    }

    Corcho getCorcho() {
        return corcho;
    }
}

class Sacacorchos {
    private boolean tieneCorcho;

    Sacacorchos() {
        this.tieneCorcho = false;
    }

    void destapar(Botella botella) {
        if (tieneCorcho) {
            System.out.println("Error: El sacacorchos ha sido usado.");
            return;
        }

        Corcho corcho = botella.getCorcho();
        if (!corcho.isEnBotella()) {
            System.out.println("Error: La botella ya está destapada.");
            return;
        }

        corcho.sacarDeBotella();
        tieneCorcho = true;
        System.out.println("Botella destapada exitosamente.");
    }

    void limpiar() {
        if (!tieneCorcho) {
            System.out.println("Error: El sacacorchos no tiene corcho.");
        } else {
            tieneCorcho = false;
            System.out.println("Sacacorchos limpiado exitosamente.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Corcho corcho = new Corcho();
        Botella botella = new Botella(corcho);
        Sacacorchos sacacorchos = new Sacacorchos();

        sacacorchos.destapar(botella);
        sacacorchos.destapar(botella);
        sacacorchos.limpiar();
        sacacorchos.limpiar();
    }
}

