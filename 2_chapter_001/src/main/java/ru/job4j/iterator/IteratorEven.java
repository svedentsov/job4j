package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс IteratorEven, возвращает только четные числа.
 */
public class IteratorEven implements Iterator {
    /**
     * Массив значений.
     */
    private final int[] array;
    /**
     * Позиция массива.
     */
    private int index = 0;

    /**
     * Конструктор.
     *
     * @param array массив значений.
     */
    public IteratorEven(int[] array) {
        this.array = array;
    }

    /**
     * Метод проверяет наличие следующего элемента массива.
     *
     * @return true, если элемент есть, иначе - false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                this.index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение следующего элемента массива.
     *
     * @return элемент массива.
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
