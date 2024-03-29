package ru.job4j.list;

/**
 * Класс реализующий стек.
 * Описывается LIFO - последний пришёл, первый ушёл.
 *
 * @param <T> параметризованный тип элемента связанного списка.
 */
public class SimpleStackLIFO<T> {
    /**
     * Динамический контейнер на базе связанного списка.
     */
    private DynamicContainerLL<T> stack = new DynamicContainerLL<>();

    /**
     * Метод добавляет объект в начало списка.
     *
     * @param data данные хранящиеся в элементе списка
     */
    public void push(T data) {
        stack.add(data);
    }

    /**
     * Метод возвращает первый объект из списка и удаляет его.
     *
     * @return значение удаленного элемента
     */
    public T poll() {
        return stack.delete();
    }

    /**
     * Обнуление размера списка.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
