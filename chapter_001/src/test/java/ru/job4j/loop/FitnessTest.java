package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {
    @Test
    public void whenIvanGreatNik() {
        int days = new Fitness().calc(95, 90);
        assertThat(days, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        int days = new Fitness().calc(90, 95);
        assertThat(days, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        int days = new Fitness().calc(50, 90);
        assertThat(days, is(2));
    }
}
