package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayCharTest {
    /**
     * Проверка, что префикс соответствует началу слова.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar();
        boolean result = word.startsWith("Hello", "He");
        assertThat(result, is(true));
    }

    /**
     * Проверка, что префикс не соответствует началу слова.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar();
        boolean result = word.startsWith("Hello", "Hi");
        assertThat(result, is(false));
    }
}
