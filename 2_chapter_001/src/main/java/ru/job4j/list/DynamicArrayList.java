package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс создает динамический список на базе массива.
 *
 * @param <T> тип данных в контейнере.
 */
public class DynamicArrayList<T> implements Iterable<T> {
    /**
     * Контейнер.
     */
    private Object[] container;
    /**
     * Счетчик добавляемых элементов коллекции.
     */
    private int counter = 0;
    /**
     * Счетчик изменений - для fail-fast поведения итератора.
     */
    private int modCount;

    /**
     * Конструктор с заданной емкостью коллекции.
     *
     * @param capacity емкость коллекции
     */
    public DynamicArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        container = new Object[capacity];
    }

    /**
     * Добавить объект в коллекцию.
     *
     * @param value добавляемое значение
     */
    public void add(T value) {
        ensureCapacity();
        container[counter++] = value;
        modCount++;
    }

    /**
     * Проверить размер коллекции и если нужно увеличить её.
     */
    private void ensureCapacity() {
        if (counter >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    /**
     * Получить элемент коллекции по индексу.
     *
     * @param index индекс искомого значения
     * @return найденный элемент
     */
    public T get(int index) {
        if (index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return (T) container[index];
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода коллекции.
     */
    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayList.DynamicArrayIterator();
    }

    /**
     * Класс реализует итератор с проверкой модификации коллекции при обходе.
     */
    private class DynamicArrayIterator implements Iterator<T> {
        private int cursor = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor < counter;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[cursor++];
        }
    }
}
