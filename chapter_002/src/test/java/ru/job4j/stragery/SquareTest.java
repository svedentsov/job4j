package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Проверка класса SquareTest.
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++")
                                .toString()
                )
        );
    }
}
