package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleStack<>();
    }

    @Test
    public void whenPushElementAndRemoveElement() {
        list.push(1);
        list.push(2);
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenRemoveElementEmptyStack() {
        list.push(1);
        list.poll();
        list.poll();
    }

    @Test
    public void whenReplaceElementWithPushAndRemove() {
        list.push(1);
        list.poll();
        list.push(2);
        assertThat(list.poll(), is(2));
    }
}
