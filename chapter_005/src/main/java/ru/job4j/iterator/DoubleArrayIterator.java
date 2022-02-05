package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор двумерного массива int.
 */
public class DoubleArrayIterator implements Iterator {
    /**
     * Входящий массив.
     */
    private final int[][] doubleArray;
    /**
     * Индекс строк.
     */
    private int row = 0;
    /**
     * Индекс столбцов.
     */
    private int column = 0;

    public DoubleArrayIterator(int[][] doubleArray) {
        this.doubleArray = doubleArray;
    }

    /**
     * Метод проверяет наличие следующего элемента массива.
     *
     * @return true если элемент найден, иначе false.
     */
    @Override
    public boolean hasNext() {
        return doubleArray.length > row
                && doubleArray[row].length > column;
    }

    /**
     * Метод возвращает следующий элемент массива.
     *
     * @return элемент массива.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        int result = doubleArray[row][column];
        if (doubleArray[row].length - 1 > column) {
            column++;
        } else {
            row++;
            column = 0;
        }
        return result;
    }
}
