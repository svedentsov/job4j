package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Проверка класса Convert.
 */
public class ConverterTest {
    /**
     * Проверка конвертации матрицы чисел в список чисел.
     */
    @Test
    public void testConvertMatrixToList() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> result = new Converter().convertMatrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }
}
