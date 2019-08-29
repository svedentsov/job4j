package ru.job4j.array;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Метод проверят все ли элементы в массиве являются true или false
     *
     * @param data массив для проверки
     * @return возвращаемый результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
