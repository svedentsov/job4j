package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTwoThenTwo() {
        boolean[][] input = new boolean[][]{
                {false, true},
                {true, false}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTwoThenTwo() {
        boolean[][] input = new boolean[][]{
                {false, true},
                {false, false}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(false));
    }
}
