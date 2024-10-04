package Prog2problemas.EjAvanzadosPOO;

class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal() {
        return imag == 0.0;
    }

    public boolean isImaginary() {
        return real == 0.0;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return this.real == another.real && this.imag == another.imag;
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        double newReal = this.real * right.real - this.imag * right.imag;
        double newImag = this.real * right.imag + this.imag * right.real;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double denom = right.real * right.real + right.imag * right.imag;
        double newReal = (this.real * right.real + this.imag * right.imag) / denom;
        double newImag = (this.imag * right.real - this.real * right.imag) / denom;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }

    public static void main(String[] args) {

        MyComplex num1 = new MyComplex(3, 4);
        MyComplex num2 = new MyComplex(1, -1);

        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);

        MyComplex result = num1.addNew(num2);
        System.out.println("Suma: " + result);

        result = num1.subtractNew(num2);
        System.out.println("Resta: " + result);

        result = num1.multiply(num2);
        System.out.println("Multiplicación: " + result);

        result = num1.divide(num2);
        System.out.println("División: " + result);

        System.out.println("Magnitud de num1: " + num1.magnitude());
        System.out.println("Argumento de num1 (en radianes): " + num1.argument());

        System.out.println("Conjugado de num1: " + num1.conjugate());
    }
}

