package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс EvenNumbersIterator реализует итератор, возвращающий только четные цифры.
 * Итератор может принимать список произвольных чисел.
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * Входящий массив.
     */
    private final int[] numbers;
    /**
     * Позиция массива.
     */
    private int index = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Метод проверяет наличие следующего элемента массива.
     *
     * @return true - элемент есть, иначе - false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
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
     * @return элемент массива.
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return numbers[index++];
    }
}
