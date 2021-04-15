package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Класс SimpleLinkedList реализует методы для односвязного списка.
 */
public class SimpleLinkedList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод добавлеяет объект в начало коллекции.
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
     * Метод получает объект из коллекции по индексу.
     *
     * @param index искомое значение
     * @return найденный объект
     */
    public E get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод удаляет объект из коллекции.
     *
     * @return удаленный элемент.
     */
    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        this.first = this.first.next;
        this.size--;
        return result.data;
    }

    /**
     * Метод получает размер коллекции.
     *
     * @return размер коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E> тип элемента хранения.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E date) {
            this.data = date;
        }
    }
}
