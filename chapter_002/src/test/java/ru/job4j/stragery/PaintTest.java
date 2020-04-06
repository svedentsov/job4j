package ru.job4j.stragery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс PaintTest для тестирования рисования фигур.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream(); // Буфер для результата.
    private final PrintStream stdout = System.out; // Поле содержит дефолтный вывод в консоль.

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out)); // Заменяем стандартный вывод на вывод в пямять для тестирования.
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout); // Возвращаем обратно стандартный вывод в консоль.
        System.out.println("execute after method");
    }

    /**
     * Тестирование рисования квадрата.
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
     * Тестирование рисования треугольника.
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
