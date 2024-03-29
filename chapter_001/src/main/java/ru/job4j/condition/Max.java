package ru.job4j.condition;

/**
 * Класс содержит метод, который возвращает больше число из двух, трех или четырех чисел.
 */
public class Max {
    /**
     * Получить максимальное значение из 2-х чисел.
     *
     * @param first  первое значение для сравнения
     * @param second второе значение для сравнения
     * @return максимальное значение
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    /**
     * Получить максимальное значение из 3-х чисел.
     *
     * @param first  первое значение для сравнения
     * @param second второе значение для сравнения
     * @param third  третье значение для сравнения
     * @return максимальное значение
     */
    public int max(int first, int second, int third) {
        int tmp = max(second, third);
        return max(first, tmp);
    }

    /**
     * Получить максимальное значение из 4-х чисел.
     *
     * @param first  первое значение для сравнения
     * @param second второе значение для сравнения
     * @param third  третье значение для сравнения
     * @param fourth четвертое значение для сравнения
     * @return максимальное значение
     */
    public int max(int first, int second, int third, int fourth) {
        int tmp = max(second, third, fourth);
        return max(first, tmp);
    }
}
