package com.andrzej.spring.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTestSuite {

    @Test
    public void testSaveData() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(LibraryConfig.class);
        Library library = context.getBean(Library.class);
        //When
        library.saveData();
    }

    @Test
    public void loadData() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(LibraryConfig.class);
        Library library = context.getBean(Library.class);
        //When
        library.loadData();
    }

    @Test
    public void testContext() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        //When & Then
        System.out.println("==========BEAN LIST++++++++++");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }

}