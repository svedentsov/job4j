package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet;

    @Before
    public void beforeTest() {
        simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
    }

    @Test
    public void whenAddFourElementThenAddTrue() {
        assertThat(simpleSet.add(4), is(true));
    }

    @Test
    public void whenAddFourSameElementThenAddFalse() {
        assertThat(simpleSet.add(2), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddFourElementAfterCreateIteratorThenExeption() {
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(1));
        simpleSet.add(4);
        it.next();
    }
}
