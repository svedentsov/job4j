package ru.job4j.array;

/**
 * Инвертирование массива.
 */
public class Turn {
    /**
     * Метод переворачивает массив.
     *
     * @param array массив.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
