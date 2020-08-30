package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Модульные тесты класса SimpleArrayList.
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void init() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenAddThreeElementsAndDeleteFirstThenGetThreeAndActualFirstIsTwoAndSizeIsTwo() {
        assertThat(list.delete(), is(3));
        assertThat(list.get(0), is(2));
        assertThat(list.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenElementsAreAbsent() {
        list = new SimpleArrayList<>();
        list.delete();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIndexIsNotCorrect() {
        list.get(3);
    }
}
