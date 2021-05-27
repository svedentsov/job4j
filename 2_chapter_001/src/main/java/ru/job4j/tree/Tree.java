package ru.job4j.tree;

import java.util.*;

/**
 * Класс реализует элементарную структуру дерева.
 *
 * @param <E> тип значения, хранящегося в узле дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Корневой элемент дерева.
     */
    private Node<E> root;

    /**
     * Конструктор инициализирующий дерево с его корневым элементом.
     *
     * @param value начальное значение, помещенное в корневой узел.
     */
    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> foundParent = findBy(parent);
        if (foundParent.isEmpty()) {
            throw new NoSuchElementException("Element not found");
        }
        if (findBy(child).isEmpty()) {
            foundParent.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> e = data.poll();
            if (e.eqValue(value)) {
                result = Optional.of(e);
                break;
            }
            for (Node<E> child : e.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Метод проверяет, является ли дерево бинарным.
     *
     * @return true - дерево бинарное, false - дерево не бинарное.
     */
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> next = data.poll();
            for (Node<E> e : next.leaves()) {
                data.offer(e);
            }
            if (next.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает итератор для обхода дерева.
     *
     * @return итератор для обхода дерева.
     */
    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<E>() {

            /**
             * Метод проверяет наличие следующих элементов.
             * @return true - элементы есть, false - элементов нет.
             */
            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            /**
             * Метод повозвращает значение узла дерева по очереди.
             * @return очередь элементов дерева.
             * @throws NoSuchElementException выбрасывается если отсутствует элемент для возврата.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Collection is empty");
                }
                Node<E> e = data.poll();
                E result = null;
                if (e != null) {
                    for (Node<E> child : e.leaves()) {
                        data.offer(child);
                    }
                    result = e.getValue();
                }
                return result;
            }
        };
    }
}
