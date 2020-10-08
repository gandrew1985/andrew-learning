package com.andrzej.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminator(List<Integer> list) {
        List<Integer> evenNumbers = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
