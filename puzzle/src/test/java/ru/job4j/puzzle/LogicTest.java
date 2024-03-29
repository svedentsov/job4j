package ru.job4j.puzzle;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {
    @Test
    public void whenVerticalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    @Test
    public void whenHorizontalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    @Test
    public void whenNotWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }

    @Test
    public void whenHorizontalWinYet() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }

    @Test
    public void whenVerticalWinYet() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }
}
