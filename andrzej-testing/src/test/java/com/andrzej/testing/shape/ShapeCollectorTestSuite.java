package com.andrzej.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTest() {
        System.out.println("Start testing....");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests completed");
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
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4,5,4);
        Square square = new Square(4);
        //When
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //Then
        Assert.assertEquals(3,shapeCollector.getSize());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4,5,4);
        Square square = new Square(4);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //When
        shapeCollector.removeFigure(circle);
        //Then
        Assert.assertEquals(2,shapeCollector.getSize());
    }

    @Test
    public void testGetFigureFromPosition() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4,5,4);
        Square square = new Square(4);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //When
        Shape figureFromPosition = shapeCollector.getFigure(4);
        System.out.println(figureFromPosition);
        //Then
        Assert.assertEquals(null, figureFromPosition);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4,5,4);
        Square square = new Square(4);
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //When
        List<Shape> shapeList = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(shapes, shapeList);

    }




}
