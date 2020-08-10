package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двухмерного массива int[][].
 */
public class IteratorForArray implements Iterator {

    /**
     * Массив значений
     */
    private final int[][] array;
    /**
     * Первый индекс.
     */
    private int row = 0;
    /**
     * Второй индекс.
     */
    private int column = 0;

    /**
     * Конструктор.
     *
     * @param array массив значений.
     */
    public IteratorForArray(int[][] array) {
        this.array = array;
    }

    /**
     * Метод проверяет наличие следующего элемента массива.
     *
     * @return true, если элемент есть, иначе - false.
     */
    @Override
    public boolean hasNext() {
        return array.length > row && array[row].length > column;
    }

    /**
     * Метод возвращает следующий элемент массива.
     *
     * @return элемент массива.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = array[row][column];
        column++;
        if (array[row].length == column) {
            column = 0;
            row++;
        }
        return result;
    }
}
