package ru.stqa.geometry.figures;

public class Triangle {

    private final double x;
    private final double y;
    private final double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Расчет периметра
    public double perimeter() {
        return x + y + z;
    }
    //Расчет площади
    public double area() {
        double s = (x + y + z) / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }

    //Вывод периметра
    public void printTrianglePerimeter() {
        var text = String.format("Периметр треугольника со сторонами: %f, %f и %f = %f", x, y, z, perimeter());
        System.out.println(text);
    }
    //Вывод площади
    public void printTriangleArea() {
        var text = String.format("Площадь треугольника со сторонами: %f, %f и %f = %f", x, y, z, area());
        System.out.println(text);
    }



}
