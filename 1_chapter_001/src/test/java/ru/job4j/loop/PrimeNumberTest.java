package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeNumberTest {
    @Test
    public void when1() {
        int count = new PrimeNumber().calc(2);
        assertThat(count, is(1));
    }

    @Test
    public void when5() {
        int count = new PrimeNumber().calc(5);
        assertThat(count, is(3));
    }

    @Test
    public void when11() {
        int count = new PrimeNumber().calc(11);
        assertThat(count, is(5));
    }
}
