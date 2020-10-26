package com.andrzej.stream.portfolio;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.Assert.*;

public class BoardTestSuite {

    public Board prepareData() {
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task2);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task5);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //Board
        Board project = new Board("Temperature project");
        project.addTaskList(taskListDone);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListToDo);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareData();
        //When
        //Then
        List<TaskList> resultLists = project.getTaskLists();
        assertEquals(3,resultLists.size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareData();
        //When
        User user1 = new User("developer1", "John Smith");
        List<Task> userTasks = project.getTaskLists().stream()
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getUserAssigned().equals(user1))
                .collect(Collectors.toList());

        double taskNr = project.getTaskLists().stream()
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getUserAssigned().equals(user1))
                .count();
        //Then
        System.out.println(taskNr);
        System.out.println(userTasks);
        assertEquals(2, userTasks.size());
        assertEquals(user1, userTasks.get(0).getUserAssigned());
        assertEquals(user1,userTasks.get(1).getUserAssigned());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareData();
        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("In progress"));
        undoneTasks.add(new TaskList("To do"));

        List<Task> expiredTasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        double expired = project.getTaskLists().stream()
                .filter(undoneTasks ::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .count();

        //Then
        System.out.println(expired);
        assertEquals(1,expiredTasks.size());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareData();
        //Then
        List<TaskList> inProgress = new ArrayList<>();
        inProgress.add(new TaskList("In progress"));
        long longTaskList = project.getTaskLists().stream()
                .filter(inProgress ::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0 )
                .count();

        List<Task> longTaskLi = project.getTaskLists().stream()
                .filter(inProgress::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> (DAYS.between(task.getCreated(), LocalDate.now())) >= 10)
                .collect(Collectors.toList());

        //When
        assertEquals(2,longTaskList);
        assertEquals(2, longTaskLi.size());
    }

    @Test
    public void testAvgLongTask() {
        //Given
        Board project = prepareData();
        //When
        List<TaskList> inProgressList = new ArrayList<>();
        inProgressList.add(new TaskList("In progress"));
        double avg = project.getTaskLists().stream()
                .filter(inProgressList::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .mapToDouble(d -> DAYS.between(d.getCreated(), LocalDate.now()))
                .average()
                .getAsDouble();


        //Then
        System.out.println(avg);
        assertEquals(10.0,avg,0);
    }



}