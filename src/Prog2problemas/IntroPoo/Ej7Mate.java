package Prog2problemas.IntroPoo;

class Mate {
    private int cebadasRestantes;
    private boolean lleno;

    public Mate(int n) {
        this.cebadasRestantes = n;
        this.lleno = false;
    }

    public int getCebadasRestantes() {
        return cebadasRestantes;
    }

    public boolean isLleno() {
        return lleno;
    }

    void cebar() {
        if (!lleno) {
            this.lleno = true;
            System.out.println("Mate cebado");
        } else {
            System.out.println("Cuidado! Te quemaste!");
        }
    }

    public void beber() {
        if (cebadasRestantes > 0) {
            if (lleno) {
                lleno = false;
                cebadasRestantes--;
                System.out.println("Has bebido del mate.");
                if (cebadasRestantes == 0) {
                    System.out.println("Advertencia: el mate está lavado.");
                }
            } else {
                System.out.println("El mate está vacío!");
            }
        } else {
            System.out.println("Advertencia: el mate está lavado.");
        }
    }


    @Override
    public String toString() {
        return "cebadasRestantes=" + cebadasRestantes + ", estado del mate=" + lleno;
    }

    public static void main(String[] args) {

        Mate miMate = new Mate(3);

        System.out.println(miMate);

        miMate.beber();

        miMate.cebar();
        System.out.println(miMate);

        miMate.beber();
        System.out.println(miMate);

        miMate.beber();

        miMate.cebar();
        System.out.println(miMate);

        miMate.beber();
        System.out.println(miMate);

        miMate.cebar();
        miMate.beber();
        System.out.println(miMate);

        miMate.cebar();
        miMate.beber();
        System.out.println(miMate);

        miMate.cebar();
        miMate.beber();
        miMate.beber();
        miMate.beber();
    }
}

