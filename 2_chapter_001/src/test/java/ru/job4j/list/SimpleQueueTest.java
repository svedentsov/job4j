package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует функционал для классов SimpleQueue и DynamicLinkedListStackContainer.
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void beforeTest() {
        simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    @Test
    public void whenPoll3ElementsShouldGetFIFO() {
        int[] result = new int[3];
        result[0] = simpleQueue.poll();
        result[1] = simpleQueue.poll();
        result[2] = simpleQueue.poll();
        int[] expected = new int[]{1, 2, 3};
        assertThat(result, is(expected));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollElementInEmptyContainerShouldGetNull() {
        simpleQueue = new SimpleQueue<>();
        assertNull(simpleQueue.poll());
    }
}
