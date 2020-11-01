package com.andrzej.spring.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.andrzej.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.add(3, 4);
        //Then
        assertEquals(7, result, 0);
    }

    @Test
    public void testSub() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.andrzej.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.sub(7, 2);
        //Then
        assertEquals(5, result, 0);
    }

    @Test
    public void testMul() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.andrzej.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.mul(3, 5);
        //Then
        assertEquals(15, result, 0);
    }

    @Test
    public void testDiv() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.andrzej.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.div(4, 2);
        //Then
        assertEquals(2, result, 0);
    }

}