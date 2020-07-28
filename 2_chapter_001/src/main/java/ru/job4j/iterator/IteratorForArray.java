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
    private int i = 0;
    /**
     * Второй индекс.
     */
    private int j = 0;

    /**
     * Конструктор.
     *
     * @param array массив значений.
     */
    public IteratorForArray(int[][] array) {
        this.array = array;
    }

    /**
     * Метод проверяет наличие следующего элемент массива.
     *
     * @return true, если элемент есть, иначе - false.
     */
    @Override
    public boolean hasNext() {
        return array.length > i && array[i].length > j;
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
        int result = array[i][j];
        j++;
        if (array[i].length == j) {
            j = 0;
            i++;
        }
        return result;
    }
}
