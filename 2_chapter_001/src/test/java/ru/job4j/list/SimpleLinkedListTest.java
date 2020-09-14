package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует функционал класса SimpleLinkedList.
 */
public class SimpleLinkedListTest {
    private SimpleLinkedList<Integer> list;

    @Before
    public void init() {
        list = new SimpleLinkedList<>();
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

    @Test
    public void whenAddThreeElementsAndDeleteFourThenLastDeleteElementReturnNull() {
        list.delete();
        list.delete();
        list.delete();
        assertNull(list.delete());
    }
}
