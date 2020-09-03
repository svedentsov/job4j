package ru.job4j.list;

/**
 * Написать алгоритм определяющий, что список содержит замыкание.
 */
public class LinkedNodeCycle<E> {
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
     * @return true - список содержит цикл, иначе - false
     */
    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        if (first != null) {
            Node<E> slow = first;
            Node<E> fast = first;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
