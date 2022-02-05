package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FitnessTest {
    @Test
    public void whenIvanGreatNik() {
        int result = new Fitness().calc(95, 90);
        assertThat(result, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        int result = new Fitness().calc(90, 95);
        assertThat(result, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        int result = new Fitness().calc(50, 90);
        assertThat(result, is(2));
    }
}
