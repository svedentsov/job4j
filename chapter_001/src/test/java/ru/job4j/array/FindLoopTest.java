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

    /**
     * Число 2 присутствует в массиве с индексом 3.
     */
    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * ЧИсло 42 отсутствует в массиве, метод FindLoop возвращает -1.
     */
    @Test
    public void whenArrayNotHaveNumber42() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 42;
        int start = 0;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Сортировка масссива из 3 чисел.
     */
    @Test
    public void whenSort3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{312, 2, 11};
        int result[] = find.sort(input);
        int[] expect = new int[]{2, 11, 312};
        assertThat(result, is(expect));
    }

    /**
     * Сортировка масссива из 5 чисел.
     */
    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 4, 1, 2, 5};
        int result[] = find.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }
}
