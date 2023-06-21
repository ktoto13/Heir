package ru.netology.heir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TasksTest {

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Subtask 1", "Subtask 2", "Subtask 3"});
        String query = "Subtask 4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInSubtasks() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(1, subtasks);
        String query = "Subtask 2";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");
        String query = "task";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");
        String query = "other";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-07-04T10:00:00Z");
        String query = "topic";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-07-04T10:00:00Z");
        String query = "project";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-07-04T10:00:00Z");
        String query = "other";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }


}
