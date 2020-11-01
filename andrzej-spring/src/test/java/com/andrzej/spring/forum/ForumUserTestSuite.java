package com.andrzej.spring.forum;

import com.andrzej.spring.calculator.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite {

    @Test
    public void testLoadUserFromContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.andrzej.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);
        //When
        String name = forumUser.getUsername();
        //Then
        assertEquals("John Smith", name);
    }
}