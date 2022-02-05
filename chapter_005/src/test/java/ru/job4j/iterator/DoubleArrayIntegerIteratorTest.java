package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DoubleArrayIntegerIteratorTest {
    @Test
    public void whenHasNextCallThenShouldReturnTrue() {
        DoubleArrayIntegerIterator it = new DoubleArrayIntegerIterator(new Integer[][]{{1, 2, 3}, {}, {21}, {31, 32}});
        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void whenHasNextCallThenShouldReturnFalse() {
        DoubleArrayIntegerIterator it = new DoubleArrayIntegerIterator(new Integer[][]{{1, 2, 3}, {}, {21}, {31, 32}});
        for (int i = 0; i < 7; i++) {
            it.next();
        }
        boolean result = it.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void whenGetNextCallToEmptyThenShouldPointedToEmpty() {
        DoubleArrayIntegerIterator it = new DoubleArrayIntegerIterator(new Integer[][]{{1, 2, 3}, {}, {21}, {31, 32}});
        it.next();
        it.next();
        it.next();
        Integer result = (Integer) it.next();
        Integer expected = null;
        assertThat(result, is(expected));
    }
}
