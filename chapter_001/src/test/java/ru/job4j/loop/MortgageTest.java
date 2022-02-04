package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MortgageTest {
    @Test
    public void when1Year() {
        int year = new Mortgage().year(1000, 100, 1);
        assertThat(year, is(1));
    }

    @Test
    public void when2Year() {
        int year = new Mortgage().year(100, 10, 50);
        assertThat(year, is(2));
    }
}
