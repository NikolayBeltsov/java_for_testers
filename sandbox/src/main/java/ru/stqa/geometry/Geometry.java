package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        /*
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);
        */

//Вывод результата по Периметру треугольника
        Triangle.printTrianglePerimeter(10.0, 5.0, 2.0);
        Triangle.printTrianglePerimeter(5.0, 5.0, 5.0);

//Вывод результата по Площади треугольника
        Triangle.printTriangleArea(10.0, 5.0, 10.0);
        Triangle.printTriangleArea(5.0, 5.0, 5.0);
    }

}
