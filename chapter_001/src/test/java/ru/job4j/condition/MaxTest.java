package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To1Then3() {
        Max max = new Max();
        int result = max.max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax5To5Then5() {
        Max max = new Max();
        int result = max.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax231Then3() {
        Max max = new Max();
        int result = max.max(2, 3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax2936Then9() {
        Max max = new Max();
        int result = max.max(2, 9, 3, 6);
        assertThat(result, is(9));
    }
}
