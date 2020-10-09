package com.andrzej.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Preparing for tests...");
    }

    @AfterClass
    public static void afterAllTest() {
        System.out.println("All tests finished!!!");
    }

    @Before
    public void beforeTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(5);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(1, shapeCollector.getSize());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(5);
        shapeCollector.addFigure(circle);
        //When
        shapeCollector.removeFigure(circle);
        //Then
        Assert.assertEquals(0, shapeCollector.getSize());
    }

    @Test
    public void testGetFigure() {
        //When
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(2, 4, 5);
        shapeCollector.addFigure(circle);
        //Then
        Shape retrievedShape = shapeCollector.getFigure(0);
        //When
        Assert.assertEquals(circle, retrievedShape);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        List<Shape> figures = new ArrayList<>();
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(2, 4, 5);
        figures.add(circle);
        figures.add(triangle);
        //When
        List<Shape> retrievedFigures = shapeCollector.showFigures(figures);
        //Then
        Assert.assertEquals(figures, retrievedFigures);
    }
}
