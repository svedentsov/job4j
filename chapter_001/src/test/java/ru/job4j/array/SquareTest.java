package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        int[] result = new Square().calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        int[] result = new Square().calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound7Then14916253649() {
        int bound = 7;
        int[] result = new Square().calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36, 49};
        assertThat(result, is(expect));
    }
}
