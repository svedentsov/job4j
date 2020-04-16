package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тестирование класса FunctionCalc.
 */
public class FunctionCalcTest {
    /**
     * Подсчёт линейной функции.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Подсчёт квадратичной функции.
     */
    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = FunctionCalc.diapason(8, 11, x -> Math.pow(x, 2) + 4 * x);
        List<Double> expected = Arrays.asList(96D, 117D, 140D);
        assertThat(result, is(expected));
    }

    /**
     * Подсчёт логарифмической функции.
     */
    @Test
    public void whenLogarithmFunctionThenLogarithmResults() {
        List<Double> result = FunctionCalc.diapason(10, 13, Math::log);
        List<Double> expected = Arrays.asList(2D, 2D, 2D);
        assertThat(result, is(expected));
    }
}
