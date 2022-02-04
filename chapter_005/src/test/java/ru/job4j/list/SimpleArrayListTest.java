package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует функционал для класса SimpleArrayList.
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> simpleArrayList;

    @Before
    public void init() {
        simpleArrayList = new SimpleArrayList<>(3);
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleArrayList.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUsingIteratorResultThree() {
        Iterator<Integer> iterator = simpleArrayList.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUsingIteratorModifyTheCollectionShouldReturnException() {
        Iterator<Integer> iterator = simpleArrayList.iterator();
        iterator.next();
        iterator.next();
        simpleArrayList.add(4);
        iterator.next();
    }
}
