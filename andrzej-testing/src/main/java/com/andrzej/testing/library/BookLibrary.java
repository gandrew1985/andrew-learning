package com.andrzej.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        int fragmentLength = titleFragment.length();
        if (fragmentLength < 3) {
            return bookList;
        }
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if(resultList.size() > 20) {
            return bookList;
        }
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBookInHandsOf(LibraryUser libraryUser) {

        List<Book> resultOfBorrowedBooksByUser = libraryDatabase.listBooksInHandsOf(libraryUser);

        return resultOfBorrowedBooksByUser;

    }
}

