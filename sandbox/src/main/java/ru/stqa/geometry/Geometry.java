package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.Queue;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.00));

        var squares = Stream.generate(randomSquare).limit(5);

        Consumer<Square> print = square -> {
            Square.printSquareArea(square);
        };
        squares.peek(Square::printSquareArea).forEach(print);

    }
}
