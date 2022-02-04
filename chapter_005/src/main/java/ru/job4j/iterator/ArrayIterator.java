package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализует итератор для двухмерного массива.
 * Корректно работает не только с квадратной матрицей, но и с jagged array.
 */
public class ArrayIterator implements Iterator {
    /**
     * Входящий массив.
     */
    private final int[][] array;
    /**
     * Индекс строк (внешний).
     */
    private int indexOut = 0;
    /**
     * Индекс столбцов (внутренний).
     */
    private int indexIn = 0;

    public ArrayIterator(int[][] arrayInt) {
        this.array = arrayInt;
    }

    /**
     * Метод проверяет наличие следующего элемента массива.
     *
     * @return true если элемент найден, иначе - false
     */
    @Override
    public boolean hasNext() {
        return array.length > indexOut
                && array[indexOut].length > indexIn;
    }

    /**
     * Метод возвращает следующий элемент массива.
     *
     * @return элемент массива
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        int result = array[indexOut][indexIn];
        if (array[indexOut].length - 1 > indexIn) {
            indexIn++;
        } else {
            indexIn = 0;
            indexOut++;
        }
        return result;
    }
}
