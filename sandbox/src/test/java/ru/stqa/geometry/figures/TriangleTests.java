package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
// Тест на проверку периметра треугольника
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(17., Triangle.trianglePerimeter(5.0, 7.0, 5.0));
    }

// Тест на проверку площади треугольника
    @Test
    void canCalculateArea() {
        Assertions.assertEquals(10.825317547305483, Triangle.triangleArea(5.0, 5.0, 5.0));
    }
}
