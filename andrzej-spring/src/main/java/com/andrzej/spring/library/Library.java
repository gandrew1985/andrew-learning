package com.andrzej.spring.library;

import org.springframework.stereotype.Service;

public final class Library {

    private LibraryDbController libraryDbController;

    public Library(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }

    public LibraryDbController getLibraryDbController() {
        return libraryDbController;
    }

    public void saveData() {
        libraryDbController.saveToDb();
    }

    public void loadData() {
        libraryDbController.loadDb();
    }
}
