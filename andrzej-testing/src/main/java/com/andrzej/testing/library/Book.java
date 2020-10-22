package com.andrzej.testing.library;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass() ) return false;

        Book book = (Book) o;

        if(!Objects.equals(title, book.title)) return false;
        if(!Objects.equals(publicationYear,book.publicationYear)) return false;
        return Objects.equals(author,book.author);
    }



    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publicationYear;
        return result;
    }

    @Override
    public String toString() {
        return "[Book: " + "\"" + title + "\" " + author + " " + publicationYear + "]";
    }
}
