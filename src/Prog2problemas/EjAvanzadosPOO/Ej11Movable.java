package Prog2problemas.EjAvanzadosPOO;

interface Movable {
    void moveUp();
    void moveDown();
    void moveRight();
    void moveLeft();
}

class Point implements Movable {
    int x, y, xSpeed, ySpeed;

    public Point(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}

class Circle implements Movable {
    int radius;
    Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }
}

class Main {
    public static void main(String[] args) {
        Point point = new Point(0, 0, 5, 10);
        System.out.println("Posición inicial del Point: " + point);

        point.moveUp();
        System.out.println("Después de mover hacia arriba: " + point);

        point.moveRight();
        System.out.println("Después de mover hacia la derecha: " + point);

        point.moveDown();
        System.out.println("Después de mover hacia abajo: " + point);

        point.moveLeft();
        System.out.println("Después de mover hacia la izquierda: " + point);

        Circle circle = new Circle(10, point);
        System.out.println("\nPosición inicial del Circle: " + circle);

        circle.moveUp();
        System.out.println("Después de mover el Circle hacia arriba: " + circle);

        circle.moveRight();
        System.out.println("Después de mover el Circle hacia la derecha: " + circle);
    }
}
