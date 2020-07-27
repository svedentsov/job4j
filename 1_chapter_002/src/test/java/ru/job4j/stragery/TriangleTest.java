package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка класса Triangle.
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+").append(System.lineSeparator())
                                .append("++").append(System.lineSeparator())
                                .append("+++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("+++++")
                                .toString()
                )
        );
    }
}
