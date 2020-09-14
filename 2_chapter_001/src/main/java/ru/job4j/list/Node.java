package ru.job4j.list;


/**
 * Класс проверяет зацикленность элементов связанного списка.
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
     * Определить если ли замыкание в списке.
     * Используется алгоритм Флойда.
     * Вводятся два итератора slow, fast.
     * Второй обходит список быстрее чем первый и если он догонит первый значит есть цикл.
     * Есть какой-либо итератор становится нуль, то значит нет циклов.
     * Поиск продолжается до тех пор пока не встретится цикл ил конец списка, что является
     * признаком окончания списка.
     *
     * @param first первое значение списка
     * @return true если список содержит замыкания, иначе false
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
