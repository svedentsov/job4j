package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

import java.util.Iterator;

/**
 * Коллекция Set на массиве.
 *
 * @param <E>
 */
public class SimpleSet<E> implements Iterable<E> {
    private DynamicContainer<E> simpleSet;

    /**
     * Конструктор.
     */
    public SimpleSet() {
        this.simpleSet = new DynamicContainer<E>(10);
    }

    /**
     * Добавить значение в коллекцию, если оно отсутствует.
     *
     * @param e добавляемое значение
     * @return true - значение добавлено, иначе - false
     */
    public boolean add(E e) {
        boolean result = false;
        if (!contains(e)) {
            this.simpleSet.add(e);
            result = true;
        }
        return result;
    }

    /**
     * Проверить наличие значения в коллекции.
     *
     * @param e проверяемое значение
     * @return true - значение присутствует, иначе - false
     */
    private boolean contains(E e) {
        boolean result = false;
        if (this.simpleSet != null) {
            for (E e1 : this.simpleSet) {
                if (e1.equals(e)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.simpleSet.iterator();
    }
}
