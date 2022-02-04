package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    /**
     * Проверка сортировки массива из 10 элементов.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = sorter.sort(input);
        int[] expect = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }

    /**
     * Проверка сортировки массива из 0 элементов.
     */
    @Test
    public void whenSortArrayWithZeroElementsThenSortedArray() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[]{};
        int[] result = sorter.sort(input);
        int[] expect = new int[]{};
        assertThat(result, is(expect));
    }

    /**
     * Проверка сортировки массима из 5 одинаковых элементов.
     */
    @Test
    public void whenSortArrayWithAllElementsEqualThenSortedArray() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[]{2, 2, 2, 2, 2};
        int[] result = sorter.sort(input);
        int[] expect = new int[]{2, 2, 2, 2, 2};
        assertThat(result, is(expect));
    }
}
