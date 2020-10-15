package com.andrzej.testing.shape;

import javax.sound.midi.Track;
import java.util.Objects;

public class Triangle implements Shape {

    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getShapeType() {
        return "triangle";
    }

    @Override
    public double getField() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return  false;

        Triangle triangle = (Triangle) o;

        if(a != triangle.a) return false;
        if(b != triangle.b) return false;
        return c == triangle.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "Shape: " + getShapeType() + " Field: " + getField();
    }
}