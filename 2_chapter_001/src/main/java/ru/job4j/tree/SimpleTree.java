package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерфейс описывает структуру элементарного дерева.
 *
 * @param <E> тип значения, ограничен в пределах классов реализующих Comparable.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Метод находит родительский узел и добавляет в него дочерний узел.
     * Родительский узел может иметь список дочерних узлов.
     *
     * @param parent родительский узел.
     * @param child  дочерний узел.
     * @return true - узел добавлен в дерево,
     * false - узел добавить не удалось, parent и child уже есть в дереве.
     */
    boolean add(E parent, E child);

    /**
     * Метод производит поиск узла по заданному значению.
     * Возвращает ненулевой узел, найденный по значению на основе алгоритма поиска по ширине дерева.
     * Структура очереди позволяет поочередно извлекать элементы каждого уровня дерева.
     * Если узел найден, выходим из цикла.
     *
     * @param value искомое значение.
     * @return искомый ненулевой узел.
     */
    Optional<Node<E>> findBy(E value);
}
