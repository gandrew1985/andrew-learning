package com.andrzej.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Testing case: begin");
    }

    @After
    public void after() {
        System.out.println("Testing case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Suit Test: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Suit Test: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> resultList = exterminator.exterminator(emptyList);
        int size = resultList.size();
        System.out.println("Testing empty list...........");
        //Then
        Assert.assertEquals(emptyList, resultList);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> normalList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                normalList.add(i);
            }
        }
        //When
        List<Integer> evenNumbers = exterminator.exterminator(normalList);
        System.out.println("Testing normal list..........");
        //Then
        Assert.assertEquals(normalList, evenNumbers);
    }
}
