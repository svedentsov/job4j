package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Класс реализует методы для односвязного списка.
 */
public class DynamicContainerLL<E> {

    private int size;
    private Node<E> first;

    /**
     * Добавить объект в начало списка.
     *
     * @param date добавляемые объект.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Получить объект из списка по индексу.
     *
     * @param index индекс объекта.
     * @return найденный объект.
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
     * Получить первый объект из списка и удалить его.
     *
     * @return удаленный объект.
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

    public int getSize() {
        return this.size;
    }

    /**
     * Обнуление размера списка.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E> тип объекта.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E date) {
            this.data = date;
        }
    }
}
