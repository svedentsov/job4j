package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<E> {
    /**
     * Размер контейнера.
     */
    private int size;
    /**
     * Ссылка на первый хранимый объект, который содержит ссылка на следующий элемент.
     */
    private Node<E> first;

    /**
     * Добавление данных в начало списка.
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
     * Получение элемента по индексу.
     *
     * @param index искомое значение
     * @return найденный элемент
     */
    public E get(int index) {
        if (size == 0 || index < 0 || size <= index) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Удаление первого элемента списка.
     *
     * @return получить удаленный элемент
     */
    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E result = this.first.data;
        this.first = this.first.next;
        this.size--;
        return result;
    }

    /**
     * Получение размера коллекции.
     *
     * @return размер коллекции
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначенный для хранения данных.
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
