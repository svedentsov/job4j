package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Структура данных на основе массива с динамическим расширением.
 */
public class DynamicContainer<E> implements Iterable<E> {
    /**
     * Контейнер.
     */
    private Object[] container;
    private int size = 0;
    private int modCount;

    public DynamicContainer() {
        this.container = new Object[1];
    }

    public DynamicContainer(int initialCapacity) {
        this.container = new Object[initialCapacity];
    }

    /**
     * Добавить значение в контейнер.
     *
     * @param value добавляемое значение
     */
    public void add(E value) {
        this.modCount++;
        ensureCapacity();
        this.container[size++] = value;
    }

    /**
     * Увеличить размера контейнера.
     */
    private void ensureCapacity() {
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    /**
     * Получить значение по индексу.
     *
     * @param index индекс искомого значения
     * @return найденный элемент
     */
    public E get(int index) {
        return (E) container[index];
    }

    /**
     * Получить размер коллекции.
     *
     * @return размер коллекции
     */
    public int getLength() {
        return container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                checkModCount();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
