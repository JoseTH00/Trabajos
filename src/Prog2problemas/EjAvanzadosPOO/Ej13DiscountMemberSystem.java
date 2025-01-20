package Prog2problemas.EjAvanzadosPOO;

import java.util.Date;

class DiscountRate {
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;
    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type) {
        if (type == null) return 0.0;
        switch (type.toLowerCase()) {
            case "premium":
                return serviceDiscountPremium;
            case "gold":
                return serviceDiscountGold;
            case "silver":
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate(String type) {
        if (type == null) return 0.0;
        switch (type.toLowerCase()) {
            case "premium":
                return productDiscountPremium;
            case "gold":
                return productDiscountGold;
            case "silver":
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }
}

class Customer {
    private String name, memberType;
    private boolean member = false;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", memberType='" + memberType + '\'' +
                ", member=" + member +
                '}';
    }
}

class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        if (customer.isMember()) {
            double discount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
            this.serviceExpense = serviceExpense * (1 - discount);
        } else {
            this.serviceExpense = serviceExpense;
        }
    }

    public void setProductExpense(double productExpense) {
        if (customer.isMember()) {
            double discount = DiscountRate.getProductDiscountRate(customer.getMemberType());
            this.productExpense = productExpense * (1 - discount);
        } else {
            this.productExpense = productExpense;
        }
    }

    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    @Override
    public String toString() {
        return "Visit{customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense + ", totalExpense=" + getTotalExpense() + "}";
    }
}

class DiscountMemberSystem {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe");
        customer.setMember(true);
        customer.setMemberType("premium");

        Visit visit = new Visit(customer, new Date());
        visit.setServiceExpense(200);
        visit.setProductExpense(100);

        System.out.println(customer);
        System.out.println(visit);
        System.out.println(visit.getTotalExpense());
    }
}
