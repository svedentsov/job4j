package ru.job4j.array;

/**
 * Класс реализует проверку заполненности массива.
 */
public class Check {
    /**
     * Проверить, что все элементы в массиве являются true или false.
     *
     * @param data массив булевых значений
     * @return true - значения однотипны, иначе false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[1] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
