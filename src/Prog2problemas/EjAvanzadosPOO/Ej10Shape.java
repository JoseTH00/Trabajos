package Prog2problemas.EjAvanzadosPOO;

abstract class Shape {
   protected String color = "red";
   protected boolean filled = true;

   public Shape() {
   }

   public Shape(String color, boolean filled) {
      this.color = color;
      this.filled = filled;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }

   public abstract double getArea();

   public abstract double getPerimeter();

   @Override
   public String toString() {
      return "Shape{" +
              "color='" + color + '\'' +
              ", filled=" + filled +
              '}';
   }
}

class Rectangle extends Shape {
   protected double width;
   protected double length;

   public Rectangle() {}

   public Rectangle(double width, double length) {
      this.width = width;
      this.length = length;
   }

   public Rectangle(String color, boolean filled, double width, double length) {
      super(color, filled);
      this.width = width;
      this.length = length;
   }

   public double getWidth() {
      return width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public double getLength() {
      return length;
   }

   public void setLength(double length) {
      this.length = length;
   }

   public double getArea() {
      return width* length;
   }

   public double getPerimeter() {
      return 2*(width+ length);
   }

   @Override
   public String toString() {
      return "Rectangle{" +
              "widht=" + width +
              ", lenght=" + length +
              ", color='" + color + '\'' +
              ", filled=" + filled +
              '}';
   }
}

class Square extends Rectangle {

   public Square() {
      super(1.0, 1.0);
   }

   public Square(double side) {
      super(side, side);
   }

   public Square(double side, String color, boolean filled) {
      super(color, filled, side, side);
   }

   public double getSide() {
      return width;
   }

   public void setSide(double side) {
      this.width = side;
      this.length = side;
   }

   public void setWidth(double side) {
      setSide(side);
   }

   public void setLength(double side) {
      setSide(side);
   }

   @Override
   public String toString() {
      return "Square[Rectangle[Shape[color=" + color + ", filled=" + filled + "], side=" + width + "]]";
   }
}


class Formas {
   public static void main(String[] args) {

         Circle circle = new Circle("red",false, 5.5 );
         System.out.println(circle);
         System.out.println("Área: " + circle.getArea());
         System.out.println("Perímetro: " + circle.getPerimeter());

         Rectangle rectangle = new Rectangle("green", true, 2.0, 4.0);
         System.out.println(rectangle);
         System.out.println("Área: " + rectangle.getArea());
         System.out.println("Perímetro: " + rectangle.getPerimeter());

         Square square = new Square(3.0, "blue", true);
         System.out.println(square);
         System.out.println("Área: " + square.getArea());
         System.out.println("Perímetro: " + square.getPerimeter());
   }


}
