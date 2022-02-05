package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EndsWithTest {
    /**
     * Проверка, что постфикс соответствует концу слова.
     */
    @Test
    public void whenEndWithPostfixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    /**
     * Проверка, что постфикс не соответствует концу слова.
     */
    @Test
    public void whenNotEndtWithPostfixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "la");
        assertThat(result, is(false));
    }
}
