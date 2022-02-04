package ru.job4j.array;

/**
 * Одномерный массив с числами возведенными в квадрат
 */
public class Square {
    /**
     * Заполнить массив степенями чисел.
     *
     * @param bound заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
     * @return результат расчета
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}
