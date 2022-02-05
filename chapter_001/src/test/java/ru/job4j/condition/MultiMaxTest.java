package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultiMaxTest {
    @Test
    public void whenFirstMax() {
        int result = new MultiMax().max(3, 11, 5);
        assertThat(result, is(11));
    }

    @Test
    public void whenSecondMax() {
        int result = new MultiMax().max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        int result = new MultiMax().max(1, 4, 12);
        assertThat(result, is(12));
    }

    @Test
    public void whenAllEquals() {
        int result = new MultiMax().max(11, 11, 11);
        assertThat(result, is(11));
    }
}