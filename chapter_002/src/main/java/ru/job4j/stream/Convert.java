package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Конвертер.
 */
public class Convert {
    /**
     * Конвертировать матрицу чисел в список чисел.
     *
     * @param integers массив чисел.
     * @return список чисел.
     */
    public List<Integer> convertMatrixToList(Integer[][] integers) {
        return Stream.of(integers)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
