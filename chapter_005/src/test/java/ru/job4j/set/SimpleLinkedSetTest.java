package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedSetTest {

    SimpleLinkedSet<Integer> container;

    @Before
    public void beforeTest() {
        container = new SimpleLinkedSet<>();
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    public void whenTryToAddExistingElementThenGetTheSameSize() {
        container.add(4);
        assertThat(container.size(), is(4));
    }

    @Test
    public void ifAddNotEqualsElementsThenSetReturnThisElements() {
        Iterator<Integer> it = container.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<Integer> it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}
