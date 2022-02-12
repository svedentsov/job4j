package ru.job4j.loop;

/**
 * Вычисление факториала.
 */
public class Factorial {
    /**
     * Получить факториал указанного числа.
     *
     * @param n число
     * @return факториал
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
