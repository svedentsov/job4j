package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Узел дерева.
 */
public class Node<E extends Comparable<E>> {
    /**
     * Значение узла.
     */
    private final E value;
    /**
     * Дочеринй узел.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Конструктор инициализирует узел.
     *
     * @param value значение узла.
     */
    public Node(E value) {
        this.value = value;
    }
    /**
     * Добавить дочерний узел.
     *
     * @param child дочерний узел.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }
    /**
     * Получить список дочерних элементов узла.
     *
     * @return список дочерние элементов.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }
    /**
     * Метод сравнивает значения.
     *
     * @param that значение для проверки.
     * @return true - значение текущего узла равно переданому значению, иначе false.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
    /**
     * Получить значение текущего узла.
     *
     * @return значение текущего узла.
     */
    public E getValue() {
        return value;
    }
}
