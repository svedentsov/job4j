package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkedListContainerTest {
    private LinkedListContainer<Integer> list;

    @Before
    public void init() {
        list = new LinkedListContainer<>();
    }

    @Test
    public void whenAddElements() {
        list.add(1);
        assertThat(list.get(0), is(1));
        list.add(2);
        assertThat(list.get(0), is(1));
    }

    @Test
    public void whenIteratorWorksCorrectly() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorWorksWithException() {
        list.add(1);
        Iterator<Integer> it = list.iterator();
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenException() {
        list.add(1);
        Iterator<Integer> it = list.iterator();
        it.next();
        list.add(2);
        it.next();
    }
}
