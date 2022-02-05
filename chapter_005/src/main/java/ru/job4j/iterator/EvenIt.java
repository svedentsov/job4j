package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор принимает список произвольных чисел и возвращает только четные значения.
 */
public class EvenIt implements Iterator {
    /**
     * Входящий массив.
     */
    private final int[] array;
    /**
     * Позиция массива.
     */
    private int index = 0;

    public EvenIt(int[] array) {
        this.array = array;
    }

    /**
     * Проверить наличие следующего элемента массива.
     *
     * @return true если элемент есть, иначе false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < array.length) {
            if (array[index] % 2 == 0) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Метод возвращает только четные числа.
     *
     * @return элемент массива
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return array[index++];
    }
}
