package ru.job4j.list;

/**
 * Класс реализует стек.
 * Описывается LIFO - последний пришёл, первый ушёл.
 *
 * @param <T> параметризованный тип элемента связанного списка.
 */
public class SimpleStack<T> {
    /**
     * Динамический контейнер на базе связанного списка.
     */
    private SimpleLinkedList<T> stackContainer = new SimpleLinkedList<>();

    /**
     * Удалить последний элемент в списке и получить его значение.
     *
     * @return значение удаленного элемента
     */
    public T poll() {
        return stackContainer.delete();
    }

    /**
     * Вставить элемент в конец связанного списка.
     *
     * @param value данные хранящиеся в элементе списка
     */
    public void push(T value) {
        stackContainer.add(value);
    }

    /**
     * Проверка отсутствия значений в коллекции.
     *
     * @return true, если список пуст, иначе false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Получить размер коллекции.
     *
     * @return размер коллекции
     */
    public int size() {
        return stackContainer.getSize();
    }
}
