package ru.job4j.list;


/**
 * Node - контейнер.
 *
 * @param <T> типа данных
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
