package com.ravi.practice;

record Size(int width, int height) {
}

record Point(int x, int y) {
}

record WindowFrame(Point origin, Size size) {

}

public class RecordsPattern {

    public static void printHeight(Object obj) {
        if (obj instanceof WindowFrame wf) {
            if (wf.size() != null) {
                int height = wf.size().height();
                System.out.println("Height using pre-Java 21 approach: " + height);
            }
        }
        if (obj instanceof WindowFrame(Point origin, Size(int width, int height))) {
            System.out.println("Height using Java 21 approach: " + height);
        }
        if (obj instanceof WindowFrame(Point origin, Size(int width, int height)) && origin.x() == 100) {
            System.out.println("origin x: " + origin.x());
        }
        if (obj instanceof WindowFrame(_, Size(_, int height))) {// unnamed variable...
            System.out.println("height::  " + height);
        }
        if (obj instanceof WindowFrame(Point origin, _)) {
            System.out.println("height::  " + origin.x());
        }
    }

    public static void main(String[] args) {
        WindowFrame wf = new WindowFrame(new Point(100, 200), new Size(300, 400));
        printHeight(wf);
        printHeight(null);
    }
}
