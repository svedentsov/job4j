package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Необходимо создать динамический контейнер с методами:
 * 1) add(E value);
 * 2) E get(int index);
 * 3) реализовать интерфейс Iterable<E>.
 * Внутри контейнер должен базироваться на массиве (Object[] container). Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено.
 * Контейнер должен быть динамическим, т.е. при полном заполнении увеличиваться.
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному изменению,
 * итератор должен кидать ConcurrentModificationException.
 * Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
 * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение,
 * с текущим значением поля modCount, если они отличаются, то генерируется исключение.
 * <p>
 * Класс создает динамический список на базе массива.
 *
 * @param <T> тип данных в контейнере.
 */
public class SimpleArrayList<T> implements Iterable<T> {

    /**
     * Контейнер.
     */
    private Object[] container;
    /**
     * Размер колелкции по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Счетчик добавляемых объектов коллекции.
     */
    private int counter = 0;
    /**
     * Счетчик изменений - для fail-fast поведения итератора.
     */
    private int modCount;

    /**
     * Конструктор по умолчанию.
     */
    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор с заданной емкостью коллекции.
     *
     * @param capacity емкость коллекции
     */
    public SimpleArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        container = new Object[capacity];
    }

    /**
     * Метод добавляет объект в коллекцию.
     *
     * @param value добавляемые объект
     */
    public void add(T value) {
        ensureCapacity();
        container[counter++] = value;
        modCount++;
    }

    /**
     * Метод проверяет размер коллекции, и увеличивает её если нужно.
     */
    private void ensureCapacity() {
        if (counter >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    /**
     * Метод получает объект из коллекции по индексу.
     *
     * @param index индекс объекта.
     * @return найденный объект.
     */
    public T get(int index) {
        if (index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return (T) container[index];
    }

    /**
     * Метод возвращает количество элементов в массиве.
     */
    public int size() {
        return this.counter;
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода коллекции.
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayList.DynamicArrayIterator();
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
