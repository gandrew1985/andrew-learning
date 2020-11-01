package com.andrzej.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderConfig {

    @Autowired
    @Qualifier("getBookOne")
    private Book book;



    @Bean
    public Reader reader() {
        return new Reader(book);
    }

    @Bean()
    public Book getBookOne() {
       return new Book("book number 1");
    }

    @Bean
    public Book getBookTwo() {
        return new Book("book nr 2");
    }
}
