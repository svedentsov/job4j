package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Модульные тесты для класса Converter.
 */
public class ConverterTest {

    /**
     * Проверка правильности всех значений после конвертации.
     */
    @Test
    public void whenTryConvertTwoNestIteratorShouldCheckThatConvertIteratorReturnCorrectValues() {
        Converter iterator = new Converter();
        List<Integer> one = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> two = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        List<Integer> three = new ArrayList<>(Arrays.asList(9, 10, 11, 12));
        List<Iterator<Integer>> list = new ArrayList<>(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        Iterator<Integer> converted = iterator.convert(list.iterator());
        int index = 0;
        int[] actual = new int[expected.length];

        while (converted.hasNext()) {
            actual[index++] = converted.next();
        }

        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * Проверка обработки исключения, если итератору передан null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGiveNullToTheConverterShouldCheckThatConverterThrowException() {
        Converter iterator = new Converter();
        iterator.convert(null);
    }

    /**
     * Проверка возврата значения false, если итератору передан пустой список.
     */
    @Test
    public void whenTryGiveEmptyListToTheConvertShouldSomethingCheck() {
        Converter iterator = new Converter();
        List<Integer> one = new ArrayList<>();
        List<Iterator<Integer>> list = new ArrayList<>(Arrays.asList(one.iterator()));

        Iterator<Integer> converted = iterator.convert(list.iterator());
        assertThat(converted.hasNext(), is(false));
    }

    /**
     * Проверить что внутренний итератор не null.
     */
    @Test
    public void whenTryGetInnerIteratorShouldCheckThatAllIsOk() {
        Converter iterator = new Converter();
        List<Integer> one = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> two = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        List<Integer> three = new ArrayList<>(Arrays.asList(9, 10, 11, 12));
        List<Iterator<Integer>> list = new ArrayList<>(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));

        Iterator<Integer> converted = iterator.convert(list.iterator());
        assertThat(converted.next(), is(notNullValue()));
    }
}
