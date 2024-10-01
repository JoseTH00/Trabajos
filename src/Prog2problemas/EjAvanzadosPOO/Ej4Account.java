package Prog2problemas.EjAvanzadosPOO;

class Account {
    private String id, name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int Credit(int amount) {
        return balance+=amount;
    }

    public int Debit(int amount) {
        if (amount<=balance) {
            return balance-amount;
        } else {
            System.out.println("La cantidad excede el balance");
        }
        return balance;
    }

    public int transferTo (Account another, int amount) {
        if (amount<=balance) {
          another.balance+=amount;
            System.out.println("Transferencia hecha con exito");
        } else {
            System.out.println("La cantidad excede el balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
            Account cuenta1 = new Account("001", "Juan");
            Account cuenta2 = new Account("002", "Maria", 500);

            cuenta1.Credit(300);
            cuenta1.Debit(100);
            cuenta1.transferTo(cuenta2, 150);

            System.out.println(cuenta1);
            System.out.println(cuenta2);
    }


}
