package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements Iterable<E> {
    /**
     * Первый элемент.
     */
    private Node<E> first;
    /**
     * Текущий элемент.
     */
    private Node<E> current;
    /**
     * Счётчик изменений.
     */
    private int modCount;
    /**
     * Размер коллекции.
     */
    private int size;

    /**
     * Добавление значения в контейнер.
     * Проверяет, если первый элемент пустой, то записывает значение в первую ячейку, иначе в последующую.
     * При каждом добавлении, счётчик изменений и размер коллекции увеличивается на 1.
     *
     * @param value значение
     */
    public void add(E value) {
        Node<E> node = new Node<>(value);
        if (first != null) {
            this.current.next = node;
            this.current = node;
        } else {
            this.first = node;
            this.current = node;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Получение элемента по индексу.
     *
     * @param index искомое значение
     * @return найденный элемент
     */
    public E get(int index) {
        Node<E> target = this.first;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.data;
    }

    /**
     * Итератор.
     *
     * @return переопределенный итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentElement = first;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentElement != null;
            }

            @Override
            public E next() {
                E result;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                result = currentElement.data;
                currentElement = currentElement.next;
                return result;
            }
        };
    }

    /**
     * Node - контейнер.
     *
     * @param <E> тип данных
     */
    private static class Node<E> {
        /**
         * Данные.
         */
        E data;
        /**
         * Указатель на следующий элемент.
         */
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
