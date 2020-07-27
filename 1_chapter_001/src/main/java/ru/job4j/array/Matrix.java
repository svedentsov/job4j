package ru.job4j.array;

/**
 * Заполнение таблицы умножения.
 */
public class Matrix {
    /**
     * Создание таблицы состоящей из перемноженных столбцов и строк.
     *
     * @param size размер таблицы
     * @return расчитанная матрица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                table[x][y] = (x + 1) * (y + 1);
            }
        }
        return table;
    }
}
