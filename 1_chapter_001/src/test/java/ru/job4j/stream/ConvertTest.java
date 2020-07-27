package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка класса Convert.
 */
public class ConvertTest {
    /**
     * Проверка конвертации матрицы чисел в список чисел.
     */
    @Test
    public void testConvertMatrixToList() {
        Convert convert = new Convert();
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> actual = convert.convertMatrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(actual, is(expected));
    }
}
