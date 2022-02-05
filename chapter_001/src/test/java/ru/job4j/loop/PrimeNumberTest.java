package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeNumberTest {
    @Test
    public void when1() {
        int result = new PrimeNumber().calc(2);
        assertThat(result, is(1));
    }

    @Test
    public void when5() {
        int result = new PrimeNumber().calc(5);
        assertThat(result, is(3));
    }

    @Test
    public void when11() {
        int result = new PrimeNumber().calc(11);
        assertThat(result, is(5));
    }
}
