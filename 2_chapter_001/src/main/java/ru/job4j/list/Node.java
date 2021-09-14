package ru.job4j.list;


/**
 * Класс проверяет зацикленность элементов связанного списка.
 *
 * @param <T> - параметризуемый тип элемента связанного списка.
 */
public class Node<T> {
    /**
     * Данные, хранимые в элементе списка.
     */
    T value;
    /**
     * Ссылка на следующий элемент списка.
     */
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод позволяет определить, содержит ли список замыкания.
     *
     * @param first первый узел списка.
     * @return true, если список содержит замыкания и false, если не содержит.
     */
    public boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> slow = first;
        Node<T> fast = first.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                result = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;
    }
}
