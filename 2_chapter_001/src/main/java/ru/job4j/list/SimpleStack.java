package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleArrayList<T> simpleArrayList;

    /**
     * Конструктор.
     */
    public SimpleStack() {
        this.simpleArrayList = new SimpleArrayList<>();
    }

    /**
     * Удалить значение из коллекции.
     *
     * @return возвращает значение и удаляет его из коллекции
     */
    public T poll() {
        return simpleArrayList.delete();
    }

    /**
     * Добавить значение в коллекцию.
     *
     * @param value добавляемое значение
     */
    public void push(T value) {
        simpleArrayList.add(value);
    }

    /**
     * Получить размер коллекции.
     *
     * @return размер коллекции
     */
    public int size() {
        return simpleArrayList.getSize();
    }

    /**
     * Проверка отсутствия значений в коллекции.
     *
     * @return true, если список пуст, иначе false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
