package com.andrzej.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board board() {
        return new Board(createToDoList(), createInProgressList(), createDoneList());
    }

    @Bean("toDo")
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean("inProgress")
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean("doneList")
    public TaskList createDoneList() {
        return new TaskList();
    }
}
