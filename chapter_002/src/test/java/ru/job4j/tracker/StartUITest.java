package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    /**
     * Проверка метода createItem.
     */
    @Test
    public void whenAddItem() {
        String[] answers = {"test name"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("test name");
        assertThat(created.getName(), is(expected.getName()));
    }
}
