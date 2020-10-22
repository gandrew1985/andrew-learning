package com.andrzej.stream.book;

import java.util.Objects;

public final class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;
    private final String signature;

    public Book(final String author, final String title, final int yearOfPublication,
                final String signature) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" + author +
                ", " + title +
                ", " + yearOfPublication + ", " + signature + '}';
    }

    @Override
    public int hashCode() {
        int result = signature != null ? signature.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if(!Objects.equals(author, book.author)) return false;
        if(!Objects.equals(yearOfPublication,book.yearOfPublication)) return false;
        if(!Objects.equals(signature,book.signature)) return false;
        return Objects.equals(title, book.title);
    }
}
