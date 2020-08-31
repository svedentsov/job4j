package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicContainerTest {
    private DynamicContainer<Integer> container;

    @Before
    public void init() {
        container = new DynamicContainer<>(3);
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    public void whenDataToContainerThenIs() {
        assertThat(container.get(0), is(1));
    }

    @Test
    public void whenContainerIsFull() {
        assertThat(container.getLength(), is(3));
        container.add(45);
        assertThat(container.getLength(), is(6));
    }

    @Test
    public void whenTestIterator() {
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenContainerException() {
        Iterator it = container.iterator();
        it.next();
        container.add(45);
        it.next();
    }
}
