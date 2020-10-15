package com.andrzej.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateBookList(int size) {
        List<Book> theBooksList = new ArrayList<>();
        for (int n = 0; n < size; n++) {
            theBooksList.add(new Book("title" + n, "author" + n, 1970 + n));
        }
        return theBooksList;
    }

    @Test
    public void testListBooksWithConditionReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan",
                2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz",
                2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOf0Books = new ArrayList<>();
        List<Book> listOf15Books = generateBookList(15);
        List<Book> listOf40Books = generateBookList(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(listOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(listOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("Book")).thenReturn(listOf40Books);
        //When
        List<Book> result0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> resultOf15Books = bookLibrary.listBooksWithCondition("ble");
        List<Book> resultOf40Books = bookLibrary.listBooksWithCondition("Book");
        //Then
        assertEquals(0, result0Books.size());
        assertEquals(15, resultOf15Books.size());
        assertEquals(0, resultOf40Books.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOf10Books = generateBookList(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(listOf10Books);
        //When
        List<Book> resultList1Of0Books = bookLibrary.listBooksWithCondition("an");
        //Then
        assertEquals(0, resultList1Of0Books.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testWhenNoBooksBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> borrowedBooks = new ArrayList<>();
        LibraryUser user = new LibraryUser("name", "surname", "pesel");
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(borrowedBooks);
        //When
        List<Book> resultOfBorrowedBooks = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(0, resultOfBorrowedBooks.size());
    }

    @Test
    public void testWhen1BookBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> borrowedBooks = generateBookList(1);
        LibraryUser user = new LibraryUser("name", "surname", "pesel");
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(borrowedBooks);
        //When
        List<Book> resultOfBorrowedBooks = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(1, resultOfBorrowedBooks.size());
    }

    @Test
    public void testWhen5BooksBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> borrowedBooks = generateBookList(5);
        LibraryUser user = new LibraryUser("name", "surname", "pesel");
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(borrowedBooks);
        //When
        List<Book> resultOfBorrowedBooks = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(5, resultOfBorrowedBooks.size());
    }
}
