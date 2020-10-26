package com.andrzej.stream.portfolio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class TaskList {

    private final List<Task> tasks = new LinkedList<>();

    private final String name;

    public TaskList(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TaskList task = (TaskList) o;
        return Objects.equals(name,task.name);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                ", name='" + name + '\'' +
                '}';
    }
}
