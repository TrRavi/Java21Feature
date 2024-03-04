package com.ravi.practice;

public class RecordsPatternInSwitch {
    public static void calculateArea(Shape shape) {
        switch (shape) {
            case Circle circle -> System.out.println("Circle area: " + circle.getArea());
            case Square square -> System.out.println("Square area: " + square.getArea());
            default -> System.out.println("Unsupported shape type");
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(10);

        calculateArea(circle);
        calculateArea(square);

    }

    interface Shape {
        double getArea();
    }

    record Circle(double radius) implements Shape {
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    record Square(double sideLength) implements Shape {
        @Override
        public double getArea() {
            return sideLength * sideLength;
        }
    }


}
