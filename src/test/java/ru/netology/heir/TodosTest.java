package ru.netology.heir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchingWithNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Полить цветы"));
        todos.add(new Epic(2, new String[]{"Забрать внучку"}));
        Task[] expected = {};
        Task[] actual = todos.search("Проверить почту");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfTasksWhenSearchingWithOneMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Полить цветы"));
        todos.add(new Epic(2, new String[]{"Забрать внучку"}));
        Task[] expected = { new SimpleTask(1, "Полить цветы") };
        Task[] actual = todos.search("цветы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfAllTasksWhenSearchingWithEmptyQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Полить цветы"));
        todos.add(new Epic(2, new String[]{"Забрать внучку"}));
        Task[] expected = { new SimpleTask(1, "Полить цветы"), new Epic(2, new String[]{"Забрать внучку"}) };
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

}

