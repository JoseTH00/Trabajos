package Prog2problemas.EjAvanzadosPOO;

class Circle {
     private double radius=1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }

    public double getCircumference() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circlee{" +
                "radius=" + radius +
                '}';
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        System.out.println("Area: "+circle1.getArea()+" "+"Circunferencia: "+ circle1.getCircumference());
        Circle circle = new Circle(2);
        System.out.println(circle);
        System.out.println("Area: "+circle.getArea()+" "+"Circunferencia: "+ circle.getCircumference());
        System.out.println();
    }
}

