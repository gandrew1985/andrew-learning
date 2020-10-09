package com.andrzej.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private int a;
    private int b;

    public Square(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String getShapeType() {
        return "Square";
    }

    @Override
    public double getField() {
        return 2 * a + 2 * b;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if((o == null) || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if(a != square.a) return false;
        return b == square.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        return 31 * result + b;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
