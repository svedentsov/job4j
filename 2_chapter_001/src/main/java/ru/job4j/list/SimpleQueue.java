package ru.job4j.list;

/**
 * Класс реализующий очередь на двух стеках.
 * Описывается FIFO - первый пришёл, первый ушёл.
 *
 * @param <T> параметризуемый тип элемента связанного списка.
 */
public class SimpleQueue<T> {
    private SimpleStack<T> inputStack;
    private SimpleStack<T> outputStack;

    public SimpleQueue() {
        this.inputStack = new SimpleStack<>();
        this.outputStack = new SimpleStack<>();
    }

    /**
     * Удалить значение из коллекции.
     * Если out-коллекция пустая, она заполняется значениями из in-коллекции до тех пор, пока in не будет пустая.
     *
     * @return возвращает значение и удаляет его из коллекции
     */
    public T poll() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.poll());
            }
        }
        return outputStack.poll();
    }

    /**
     * Добавить значение в коллекцию.
     *
     * @param value добавляемое значение
     */
    public void push(T value) {
        this.inputStack.push(value);
    }
}
