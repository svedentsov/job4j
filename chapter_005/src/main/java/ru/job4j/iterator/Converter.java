package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализует итератор чисел из итератора итераторов.
 */
public class Converter {
    /**
     * Итератор итераторов.
     *
     * @param it итератор итераторов.
     * @return итератор.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> inner = it.next();

            @Override
            public boolean hasNext() {
                if (inner == null) {
                    return false;
                }
                while (!inner.hasNext() && it.hasNext()) {
                    inner = it.next();
                }
                return inner.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден");
                }
                return inner.next();
            }
        };
    }
}
