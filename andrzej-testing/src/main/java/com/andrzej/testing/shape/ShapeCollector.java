package com.andrzej.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figuresList = new ArrayList<>();

    public void addFigure(Shape shape) {
        figuresList.add(shape);
    }

    public Shape getFigure(int i) {
        Shape figure = null;
        if (i >= 0 && i < figuresList.size()) {
            figure = figuresList.get(i);
        }
        return figure;
    }

    public boolean removeFigure(Shape shape) {
        boolean removed = false;
        if(figuresList.contains(shape)) {
            figuresList.remove(shape);
            removed = true;
        }
        return removed;
    }

    public List<Shape> showFigures(List<Shape> figuresList) {
        return figuresList;
    }

    public int getSize() {
        return figuresList.size();
    }
}
