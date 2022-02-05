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
 * @param <E> тип данных в контейнере.
 */
public class SimpleArrayList<E> implements BaseList<E> {
    /**
     * Контейнер.
     */
    private E[] container;
    /**
     * Размер коллекции по умолчанию.
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
        this.container = (E[]) new Object[capacity];
    }

    /**
     * Метод добавляет объект в коллекцию.
     *
     * @param value добавляемые объект
     */
    @Override
    public boolean add(E value) {
        if (counter < container.length) {
            container[counter++] = value;
        } else {
            container = ensureCapacity();
            container[counter++] = value;
        }
        modCount++;
        return true;
    }

    /**
     * Метод проверяет размер коллекции, и увеличивает её если нужно.
     */
    @Override
    public E[] ensureCapacity() {
        int oldCapacity = container.length;
        int newCapacity = oldCapacity * 2;
        return (E[]) Arrays.copyOf(container, newCapacity);
    }

    /**
     * Метод получает объект из коллекции по индексу.
     *
     * @param index индекс объекта.
     * @return найденный объект.
     */
    @Override
    public E get(int index) {
        if (index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return (E) container[index];
    }

    /**
     * Метод возвращает количество элементов в массиве.
     */
    public int size() {
        return this.container.length;
    }

    /**
     * Вспомогательный метод, получает размер заполненной части листа.
     *
     * @return размер листа.
     */
    public int getSize() {
        return this.counter;
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода коллекции.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayList.DynamicArrayIterator();
    }

    /**
     * Класс реализует итератор с проверкой модификации коллекции при обходе.
     */
    private class DynamicArrayIterator implements Iterator<E> {
        private int cursor = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor < counter;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (E) container[cursor++];
        }
    }
}
