package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
// Тест на проверку периметра треугольника
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(17., new Triangle(5.0, 7.0, 5.0).perimeter());
    }

// Тест на проверку площади треугольника
    @Test
    void canCalculateArea() {
        Assertions.assertEquals(12.497499749949988, new Triangle(5.0, 7.0, 5.0).area());
    }

//Тест на проверку наличия отрицательных сторон
    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 7.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

//Тест на проверку нарушения неравенства
    @Test
    void testInvalidTriangleInequality() {
        try {
            new Triangle(1.0, 7.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }

    }

//Тест на проверку равенства треугольников
    @Test
    void testEquality() {
        var t1 = new Triangle(6.0, 7.0, 5.0);
        var t2 = new Triangle(7.0, 5.0, 6.0);
        Assertions.assertEquals(t1, t2);
    }
}
