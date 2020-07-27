package ru.job4j.array;

/**
 * Проверка содержимого массива.
 */
public class Check {
    /**
     * Метод проверят все ли элементы в массиве являются true или false.
     *
     * @param data массив для проверки
     * @return возвращаемый результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean first = data[0];
        for (boolean element : data) {
            if (element != first) {
                result = false;
                break;
            }
        }
        return result;
    }
}
