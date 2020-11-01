package com.andrzej.spring.library;

import org.springframework.stereotype.Repository;

public final class LibraryDbController {

    public void saveToDb() {
        System.out.println("Saving data to db");
    }

    public void loadDb() {
        System.out.println("Loading data from");;
    }
}
