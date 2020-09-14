package ru.job4j.list;

/**
 * Класс реализует методы для односвязного списка.
 */
public class SimpleLinkedList<E> {
    /**
     * Размер контейнера.
     */
    private int size;
    /**
     * Ссылка на первый хранимый объект, который содержит ссылка на следующий элемент.
     */
    private Node<E> first;

    /**
     * Вставить элемент в начало списка.
     * Осуществляется сдвиг всех элементов вправо, новый элемент добавляется слева.
     *
     * @param date добавляемые данные
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Получить элемент по индексу.
     *
     * @param index искомое значение
     * @return найденный элемент
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Удалить первый элемент списка.
     *
     * @return получить удаленный элемент
     */
    public E delete() {
        E result = null;
        if (size > 0) {
            result = this.first.data;
            this.first = this.first.next;
            size--;
        }
        return result;
    }

    /**
     * Получить размер коллекции.
     *
     * @return размер коллекции
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E> тип элемента хранения
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E date) {
            this.data = date;
        }
    }
}
