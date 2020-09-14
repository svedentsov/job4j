package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует функционал класса DynamicLinkedList.
 */
public class DynamicLinkedListTest {
    private DynamicLinkedList<Integer> dynamicLinkedList;

    @Before
    public void init() {
        dynamicLinkedList = new DynamicLinkedList<>();
        dynamicLinkedList.add(1);
        dynamicLinkedList.add(2);
        dynamicLinkedList.add(3);
    }

    @Test
    public void whenUseGetOneResultTwo() {
        assertThat(dynamicLinkedList.get(1), is(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenUseGetThreeShouldReturnException() {
        dynamicLinkedList.get(3);
    }

    @Test
    public void whenUsingIteratorResultThree() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenUsingIteratorModifyTheCollectionShouldReturnException() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        dynamicLinkedList.add(4);
        iterator.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenUsingIteratorNoNextElementShouldReturnException() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
