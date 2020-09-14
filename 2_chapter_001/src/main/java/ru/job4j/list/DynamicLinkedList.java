package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс создает динамический контейнер на базе связанного списка.
 *
 * @param <E> тип данных в контейнере
 */
public class DynamicLinkedList<E> implements Iterable<E> {
    /**
     * Сcылка на первый элемент списка.
     */
    private Node<E> first;
    /**
     * Сcылка на последний элемент списка.
     */
    private Node<E> last;
    /**
     * Счетчик изменений для fail-fast поведения итератора.
     */
    private int modCount = 0;

    /**
     * Вставить элемент в конец связанного списка.
     * Проверяет, если первый элемент пустой, то записывает значение в первую ячейку, иначе в последующую.
     * При каждом добавлении, счётчик изменений и размер коллекции увеличивается на 1.
     *
     * @param value данные, хранимые в элементе списка.
     */
    public void add(E value) {
        Node<E> newElement = new Node<>(value);
        if (first == null) {
            first = newElement;
        } else {
            last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newElement;
        }
        modCount++;
    }

    /**
     * Получение элемента по индексу.
     *
     * @param index искомое значение
     * @return найденный элемент
     */
    public E get(int index) {
        if (index < 0 || index >= modCount) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<E> iterator = iterator();
        E result = null;
        for (int i = 0; i <= index; i++) {
            result = iterator.next();
        }
        return result;
    }

    /**
     * Метод возвращает итератор, предназначенный для обхода связанного списка.
     *
     * @return - итератор с типом возвращаемого значения <E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicLinkedList.DynamicLinkedIterator();
    }

    /**
     * Класс реализует итератор с проверкой модификации связанного списка при обходе.
     */
    private class DynamicLinkedIterator implements Iterator<E> {
        /**
         * Текущая позиция итератора.
         */
        private Node<E> cursor = first;
        /**
         * Значение счетчика на момент создания итератора.
         */
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            E result = cursor.data;
            cursor = cursor.next;
            return result;
        }
    }

    /**
     * Класс для хранения данных связанного списка.
     *
     * @param <E> данные, хранимые в элементе списка.
     */
    private static class Node<E> {
        /**
         * Данные, хранимые в элементе списка.
         */
        E data;
        /**
         * Сcылка на следующий элемент списка.
         */
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
