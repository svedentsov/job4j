package ru.job4j.array;

/**
 * Класс с проверкой, что все элементы массива по диагоналям равны true или false.
 */
public class MatrixCheck {
    /**
     * Метод проверяет, что все элементы по диагоналям равны true или false,
     *
     * @param data заданный массив.
     * @return true - все элементы по диагонали однотипны, иначе false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
