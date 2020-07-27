package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {
    /**
     * Проверка метода FindByNameAction.execute.
     */
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(byteOut));
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[]{"test"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Name: " + item.getName() + " id: " + item.getId())
                .toString();
        assertThat(new String(byteOut.toByteArray()), is(expect));
        System.setOut(def);
    }
}
