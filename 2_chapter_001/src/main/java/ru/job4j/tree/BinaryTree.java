package ru.job4j.tree;

/**
 * Бинарное дерево поиска.
 */
public class BinaryTree<E extends Comparable<E>> {
    /**
     * Корень дерева.
     */
    private TreeNode<E> root;
    /**
     * Количество элементов в дереве.
     */
    private int size;

    /**
     * Инициализации начального размера дерева.
     */
    public BinaryTree() {
        this.size = 0;
    }

    /**
     * Добавить новое значения в дерево.
     *
     * @param e значение для добавления
     */
    public void add(E e) {
        this.root = this.search(this.root, e);
        this.size++;
    }

    /**
     * Найти нужный узел для создания его дочернего элемента. Реализуется за счет рекурсии.
     * Если добавляемое значение меньше или равно корню идем по левой ветке,
     * если больше, то по правой до тех пор пока узел не будет равен null -> дошли до низа.
     *
     * @param node узел для поиска
     * @param e    значение для добавления
     * @return дерево с добавленным значением
     */
    private TreeNode<E> search(TreeNode<E> node, E e) {
        if (node == null) {
            node = new TreeNode<>(e);
        } else if (e.compareTo(node.value) <= 0) {
            node.left = search(node.left, e);
        } else {
            node.right = search(node.right, e);
        }
        return node;
    }

    /**
     * Получить количество элементов в дереве.
     *
     * @return размер дерева.
     */
    public int size() {
        return this.size;
    }

    /**
     * Получить корневой элемент.
     *
     * @return корневой элемент
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Узел бинарного дерева.
     *
     * @param <E> параметризованный тип
     */
    class TreeNode<E> {
        /**
         * Значение узла.
         */
        private E value;
        /**
         * Указатель на левый дочерний элемент.
         */
        private TreeNode<E> left;
        /**
         * Указатель на правый дочерний элемент.
         */
        private TreeNode<E> right;

        /**
         * Конструктор для инициализации узла.
         *
         * @param value значение узла
         */
        public TreeNode(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        public TreeNode<E> getLeft() {
            return this.left;
        }

        public TreeNode<E> getRight() {
            return this.right;
        }
    }
}
