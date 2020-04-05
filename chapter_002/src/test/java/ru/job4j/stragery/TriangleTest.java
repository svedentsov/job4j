package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TriangleTest для тестирования рисования треугольника.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+\r\n")
                                .append("++\r\n")
                                .append("+++\r\n")
                                .append("++++\r\n")
                                .append("+++++")
                                .toString()
                )
        );
    }
}