package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test
    public void when0then1() {
        Fact fact = new Fact();
        int rsl = fact.calc(0);
        assertThat(rsl, is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumber() {
        Fact fact = new Fact();
        int rsl = fact.calc(-1);
    }
}
