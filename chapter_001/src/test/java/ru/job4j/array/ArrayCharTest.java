package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayCharTest {
    /**
     * Проверка, что префикс соответствует началу слова.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        boolean result = new ArrayChar().startWith("Hello", "He");
        assertThat(result, is(true));
    }

    /**
     * Проверка, что префикс не соответствует началу слова.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        boolean result = new ArrayChar().startWith("Hello", "Hi");
        assertThat(result, is(false));
    }
}
