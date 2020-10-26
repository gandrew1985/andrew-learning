package com.andrzej.stream.portfolio;

import java.time.LocalDate;

public final class Task {

    private final String title;
    private final String description;
    private final User userAssigned;
    private final User userCreator;
    private final LocalDate created;
    private final LocalDate deadline;

    public Task(final String title, final String description, final User userAssigned,
                final User userCreator, final LocalDate created, final LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.userAssigned = userAssigned;
        this.userCreator = userCreator;
        this.created = created;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUserAssigned() {
        return userAssigned;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userAssigned=" + userAssigned +
                ", userCreator=" + userCreator +
                ", created=" + created +
                ", deadline=" + deadline +
                '}';
    }
}
