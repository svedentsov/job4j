package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


/**
 * Класс тестирует функционал для классов SimpleStack и DynamicLinkedListStackContainer.
 */
public class SimpleStackTest {
    private SimpleStack<Integer> simpleStack;

    @Before
    public void beforeTest() {
        simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void whenPushElementAndRemoveElement() {
        simpleStack.push(1);
        simpleStack.push(2);
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

    @Test
    public void whenPoll2ElementsShouldGetLIFO() {
        int[] result = new int[3];
        result[0] = simpleStack.poll();
        result[1] = simpleStack.poll();
        result[2] = simpleStack.poll();
        int[] expected = new int[]{3, 2, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void whenPollElementInEmptyStackContainerShouldGetNull() {
        simpleStack = new SimpleStack<>();
        assertNull(simpleStack.poll());
    }
}
