package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArraySetTest {

    private SimpleArraySet<Integer> container;

    @Before
    public void beforeTest() {
        container = new SimpleArraySet<>();
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    public void whenAddThreeDifferentThenSizeThree() {
        assertThat(container.size(), is(3));
    }

    @Test
    public void whenAddThreeDifferentAndOneCloneThenSizeThree() {
        container.add(1);
        assertThat(container.size(), is(3));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddDuplicateElementsThenSizeDoesNotChange() {
        assertThat(container.size(), is(3));
        container.add(3);
        assertThat(container.size(), is(3));
        container.add(null);
        assertThat(container.size(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterateAndModifiedThenException() {
        container = new SimpleArraySet<>(2);
        container.add(1);
        container.add(2);
        Iterator<Integer> it = container.iterator();
        assertThat(it.next(), is(1));
        container.add(3);
        it.next();
    }
}
