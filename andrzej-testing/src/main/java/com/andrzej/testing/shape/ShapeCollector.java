package com.andrzej.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape figure) {
        figures.add(figure);
    }

    public boolean removeFigure(Shape figure) {
        boolean removed = false;
        if(figures.contains(figure)) {
            figures.remove(figure);
            removed = true;
        }
        return removed;
    }

    public Shape getFigure(int n) {
        Shape figure = null;
        if(n >=0 && n < figures.size()) {
            figure = figures.get(n);
        }
        return figure;
    }

    public int getSize() {
        return figures.size();
    }

    public List<Shape> showFigures() {
        return figures;
    }
}


