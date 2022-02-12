package ru.job4j.loop;

/**
 * Расчет суммы четных числе в диапазоне.
 */
public class Counter {
    /**
     * Метод для расчета суммы четных числе в диапазоне.
     *
     * @param start  первое значение диапазона.
     * @param finish второе значение диапазона.
     * @return сумма четных числе в диапазоне.
     */
    public int add(int start, int finish) {
        int sum = 0;
        if (start % 2 != 0) {
            start++;
        }
        for (int i = start; i <= finish; i = i + 2) {
            sum = sum + i;
        }
        return sum;
    }
}
