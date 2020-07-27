package ru.job4j.stragery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка класса PaintTest.
 */
public class PaintTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream(); // Буфер для результата.
    private final PrintStream stdout = System.out; // Поле содержит дефолтный вывод в консоль.

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Рисование квадрата.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Рисование треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("+").append(System.lineSeparator())
                                .append("++").append(System.lineSeparator())
                                .append("+++").append(System.lineSeparator())
                                .append("++++").append(System.lineSeparator())
                                .append("+++++").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
