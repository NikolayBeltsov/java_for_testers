package ru.stqa.geometry.figures;

public record Triangle(double x, double y, double z) {
//Вывод периметра
    public static void printTrianglePerimeter(double x, double y, double z) {
        var text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", x, y, z, trianglePerimeter(x, y, z));
        System.out.println(text);
    }
//Вывод площади
    public static void printTriangleArea(double x, double y, double z) {
        var text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", x, y, z, triangleArea(x, y, z));
        System.out.println(text);
    }

//Расчет периметра
    public static double trianglePerimeter(double x, double y, double z) {
        return x + y + z;
    }
//Расчет площади
    public static double triangleArea(double x, double y, double z) {
        double s = (x + y + z) / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }



}
