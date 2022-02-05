package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindLoopTest {
    /**
     * Число 5 присутствует в массиве с индексом 0.
     */
    @Test
    public void whenArrayHas5Then0() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = new FindLoop().indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Число 23 присутствует в массиве с индексом 3.
     */
    @Test
    public void whenArrayHas23Then3() {
        int[] input = new int[]{5, 10, 3, 23, 2, 82};
        int value = 23;
        int expect = 3;
        int result = new FindLoop().indexOf(input, value);
        assertThat(result, is(expect));
    }

    /**
     * Число 13 отсутствует в массиве, метод FindLoop возвращает -1.
     */
    @Test
    public void whenArrayNotHaveNumber13() {
        int[] input = new int[]{5, 10, 3, 23, 2, 82};
        int value = 13;
        int expect = -1;
        int result = new FindLoop().indexOf(input, value);
        assertThat(result, is(expect));
    }

    /**
     * Число 2 присутствует в массиве с индексом 3.
     */
    @Test
    public void whenFind3() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int expect = 3;
        int result = new FindLoop().indexOf(input, value, start, finish);
        assertThat(result, is(expect));
    }

    /**
     * Число 42 отсутствует в массиве, метод FindLoop возвращает -1.
     */
    @Test
    public void whenArrayNotHaveNumber42() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 42;
        int start = 0;
        int finish = 4;
        int expect = -1;
        int result = new FindLoop().indexOf(input, value, start, finish);
        assertThat(result, is(expect));
    }

    /**
     * Сортировка массива из 3 чисел.
     */
    @Test
    public void whenSort3() {
        int[] input = new int[]{312, 2, 11};
        int[] expect = new int[]{2, 11, 312};
        int[] result = new FindLoop().sort(input);
        assertThat(result, is(expect));
    }

    /**
     * Сортировка массива из 5 чисел.
     */
    @Test
    public void whenSort5() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] expect = new int[]{1, 2, 3, 4, 5};
        int[] result = new FindLoop().sort(input);
        assertThat(result, is(expect));
    }
}
