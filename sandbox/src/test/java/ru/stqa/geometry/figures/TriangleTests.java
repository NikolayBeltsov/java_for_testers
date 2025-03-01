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
}
