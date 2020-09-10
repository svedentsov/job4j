package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Узел дерева.
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    /**
     * Конструктор инициализирует узел.
     *
     * @param value значение
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавить дочерний узел.
     *
     * @param child дочерний узел
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Получить список дочерних элементов узла.
     *
     * @return дочерние элементы
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравнить узлы.
     *
     * @param that переданное значение
     * @return true, если значение текущего узла равно переданному значению.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}
