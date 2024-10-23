package Prog2problemas.EjAvanzadosPOO;

class Circle extends Shape implements GeometricObject {
    protected double radius=1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }

    public double getCircumference() {
        return 2*Math.PI*radius;
    }

    public double getPerimeter() {return 2*Math.PI*radius;}

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
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

