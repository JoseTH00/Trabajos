package Prog2problemas.EjAvanzadosPOO;

interface GeometricObject {
    public double getPerimeter();
    public double getArea();
}

interface Resizable {
    public double resize(double percent);
}

class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public double resize(double percent) {
        return radius*(1+(percent/100));
    }

    @Override
    public String toString() {
        return "ResizableCircle{" +
                "radius=" + radius +
                '}';
    }
}
class GeometricObjectResizable {
    public static void main(String[] args) {

        ResizableCircle resizableCircle = new ResizableCircle(10.0);
        System.out.println(resizableCircle);
        System.out.println("Perímetro original: " + resizableCircle.getPerimeter());
        System.out.println("Área original: " + resizableCircle.getArea());

        double nuevoRadio = resizableCircle.resize(50);

        System.out.println("Nuevo radio después de redimensionar al 50%: " + nuevoRadio);

        ResizableCircle nuevoCirculo = new ResizableCircle(nuevoRadio);

        System.out.println(nuevoCirculo);
        System.out.println("Perímetro después de redimensionar: " + nuevoCirculo.getPerimeter());
        System.out.println("Área después de redimensionar: " + nuevoCirculo.getArea());
    }
}
