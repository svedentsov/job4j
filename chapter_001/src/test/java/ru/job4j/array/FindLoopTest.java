package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    /**
     * Число 5 присутствует в массиве с индексом 0.
     */
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Число 23 присутствует в массиве с индексом 3.
     */
    @Test
    public void whenArrayHas23Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3, 23, 2, 82};
        int value = 23;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * Число 13 отсутствует в массиве, метод FindLoop возвращает -1.
     */
    @Test
    public void whenArrayNotHaveNumber13() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3, 23, 2, 82};
        int value = 13;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
