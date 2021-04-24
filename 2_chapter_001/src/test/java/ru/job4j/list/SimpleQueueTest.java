package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenPoll3ElementsShouldGetFIFO() {
        int[] result = new int[3];
        result[0] = queue.poll();
        result[1] = queue.poll();
        result[2] = queue.poll();
        int[] expected = new int[]{1, 2, 3};
        assertThat(result, is(expected));
    }

    @Test
    public void whenPollElementInEmptyContainerShouldGetNull() {
        queue = new SimpleQueue<>();
        assertNull(queue.poll());
    }
}
