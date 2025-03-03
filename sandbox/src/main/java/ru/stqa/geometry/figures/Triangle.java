package ru.stqa.geometry.figures;

import java.util.Arrays;
import java.util.Objects;

public class Triangle {

    private final double x;
    private final double y;
    private final double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        //Проверка на отрицательные стороны
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("Треугольник содержит отрицательные стороны");
        }
        //Проверка неравенства треугольника
        if (!isValidTriangle(x, y, z)) {
            throw  new IllegalArgumentException("Неравенство треугольника нарушено");
        }

    }
    //Метод для проверки неравенства треугольника
    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c && a + c > b && b + c > a);
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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        //Создание массивов со сторонами треугольников
        double[] triangleSides1 = {triangle.x, triangle.y, triangle.z};
        double[] triangleSides2 = {this.x, this.y, this.z};
        //Сортировка
        Arrays.sort(triangleSides1);
        Arrays.sort(triangleSides2);
        //Сравнение массивов
        return Arrays.equals(triangleSides1, triangleSides2);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
