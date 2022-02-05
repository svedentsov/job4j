package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MortgageTest {
    @Test
    public void when1Year() {
        int result = new Mortgage().year(1000, 100, 1);
        assertThat(result, is(1));
    }

    @Test
    public void when2Year() {
        int result = new Mortgage().year(100, 10, 50);
        assertThat(result, is(2));
    }
}
