package com.andrzej.stream;

import com.andrzej.stream.book.Book;
import com.andrzej.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        BookDirectory bookDirectory = new BookDirectory();

        String theResultString = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication()> 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<", ">>"));

        System.out.println(theResultString);

    }
}
