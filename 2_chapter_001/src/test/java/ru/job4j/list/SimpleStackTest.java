package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleStackTest {

    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPushElementAndRemoveElement() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    @Test
    public void whenPoll2ElementsShouldGetLIFO() {
        int[] result = new int[3];
        result[0] = stack.poll();
        result[1] = stack.poll();
        result[2] = stack.poll();
        int[] expected = new int[]{3, 2, 1};
        assertThat(result, is(expected));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollElementInEmptyStackContainerShouldGetNull() {
        stack = new SimpleStack<>();
        assertNull(stack.poll());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddThreeElementsAndGetFourElementThenNoSuchElemException() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        stack.poll();
    }
}
