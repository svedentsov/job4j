package ru.job4j.array;

/**
 * Класс реализует проверку, как заполнен массив.
 */
public class Check {
    /**
     * Метод проверят на однотипность все элементы массива.
     *
     * @param data массив булевых значений
     * @return true если значения однотипны, иначе false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
