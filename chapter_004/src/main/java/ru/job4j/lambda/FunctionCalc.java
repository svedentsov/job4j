package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalc {
    /**
     * Подсчёт функции в диапазоне.
     *
     * @param start начальное значение диапазона.
     * @param end   конечное значение диапазона.
     * @param func  функциональный интерфейс.
     * @return подсчитанное значение.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add((double) Math.round(func.apply((double) i)));
        }
        return result;
    }
}
