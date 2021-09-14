package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Необходимо создать динамический контейнер с методами:
 * 1) add(E value);
 * 2) E get(int index);
 * 3) реализовать интерфейс Iterable<E>.
 * Внутри контейнер должен базироваться на связанном списке(Node<E> node). Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено.
 * Контейнер должен быть динамическим, т.е. увеличиваться по мере добавления элементов.
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному изменению,
 * итератор должен кидать ConcurrentModificationException.
 * Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
 * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение,
 * с текущим значением поля modCount, если они отличаются, то генерируется исключение.
 * <p>
 * Класс создает динамический контейнер на базе связанного списка.
 *
 * @param <E> тип данных в контейнере.
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    /**
     * Первый объект списка.
     */
    private Node<E> first;
    /**
     * Последний объект списка.
     */
    private Node<E> last;
    /**
     * Счётчик изменений.
     */
    private int modCount;
    /**
     * Размер коллекции.
     */
    private int size;

    /**
     * Метод добавляет объект в конец связанного списка.
     * Проверяет, если первый объект пустой, то записывает значение в первую ячейку, иначе в последующую.
     * При каждом добавлении, счётчик изменений и размер коллекции увеличивается на 1.
     *
     * @param value данные, хранимые в объекте списка.
     */
    public void add(E value) {
        Node<E> node = new Node<>(value);
        modCount++;
        size++;
        if (this.first == null) {
            this.first = node;
            this.last = node;
        }
        if (1 < size) {
            this.last.next = node;
            this.last = node;
        }
    }

    /**
     * Метод получает элемент по индексу.
     *
     * @param index искомое значение.
     * @return найденный элемент.
     */
    public E get(int index) {
        if (index < 0 || this.size < index) {
            throw new NoSuchElementException();
        }
        E result = null;
        if (index < this.size) {
            Node<E> nodeWithResult = this.first;
            for (int i = 1; i <= index; i++) {
                nodeWithResult = nodeWithResult.next;
            }
            result = nodeWithResult.data;
        }
        return result;
    }

    /**
     * Итератор.
     *
     * @return переопределенный итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                this.checkModCount();
                return this.currentNode != null;
            }

            @Override
            public E next() {
                this.checkModCount();
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = this.currentNode.data;
                this.currentNode = this.currentNode.next;
                return result;
            }

            private void checkModCount() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    /**
     * Метод возвращает количество элементов в массиве.
     */
    public int size() {
        return this.size;
    }

    /**
     * Класс для хранения данных связанного списка.
     *
     * @param <E> тип данных, хранимые в элементе списка.
     */
    private static class Node<E> {
        /**
         * Данные, хранимые в элементе списка.
         */
        E data;
        /**
         * Ссылка на следующий элемент списка.
         */
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
