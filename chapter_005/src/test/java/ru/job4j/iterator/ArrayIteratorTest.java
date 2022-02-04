package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayIteratorTest {
    private ArrayIterator it;

    @Before
    public void setUp() {
        it = new ArrayIterator(new int[][]{{1}, {3, 4}, {6, 7}});
    }

    @Test
    public void testsThatNextMethodDoestDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoestAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }


    @Test
    public void whenThreeArrayWithoutNull() {
        ArrayIterator it = new ArrayIterator(new int[][]{{1}, {2}, {3, 5}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void testException() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testShouldThrowNoSuchElementException() {
        it = new ArrayIterator(new int[][]{});
        it.next();
    }
}
