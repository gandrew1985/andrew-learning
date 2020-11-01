package com.andrzej.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreApp {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> moviesMap = movieStore.getMovies();

        String token = moviesMap.entrySet().stream()
                .flatMap(m -> m.getValue().stream())
                .collect(Collectors.joining("!","",""));

        System.out.println(token);


    }
}
