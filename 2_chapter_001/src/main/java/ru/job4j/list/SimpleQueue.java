package ru.job4j.list;

/**
 * Класс реализующий очередь на двух стеках.
 * Описывается FIFO - первый зашел и первый вышел.
 *
 * @param <T> параметризуемый тип элемента связанного списка.
 */
public class SimpleQueue<T> {

    /**
     * Поле первого стека.
     */
    private SimpleStackFIFO<T> stackOne = new SimpleStackFIFO<>();
    /**
     * Поле второго стека.
     */
    private SimpleStackFIFO<T> stackTwo = new SimpleStackFIFO<>();

    /**
     * Метод вставляет объект в начало списка, используя первый стек.
     *
     * @param data добавляемое значение
     */
    public void push(T data) {
        this.stackOne.push(data);
    }

    /**
     * Метод удаляет элемент из очереди и возвращает его значение.
     * Если out-коллекция пустая, она заполняется значениями из in-коллекции до тех пор, пока in не будет пустая.
     *
     * @return возвращает значение и удаляет его из коллекции
     */
    public T poll() {
        if (stackTwo.size() == 0) {
            int stackSize = stackOne.size();
            for (int i = 0; i < stackSize; i++) {
                stackTwo.push(stackOne.poll());
            }
        }
        return stackTwo.poll();
    }
}
