package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = new Max().max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To1Then3() {
        int result = new Max().max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax5To5Then5() {
        int result = new Max().max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax231Then3() {
        int result = new Max().max(2, 3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax2936Then9() {
        int result = new Max().max(2, 9, 3, 6);
        assertThat(result, is(9));
    }
}
