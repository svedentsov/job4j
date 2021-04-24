package ru.job4j.set;

import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;
import java.util.Objects;

/**
 * Класс реализует коллекцию Set на базе.
 *
 * @param <E> тип данных в коллекции.
 */
public class SimpleSet<E> implements Iterable<E> {

    private DynamicArrayList<E> container;

    /**
     * Конструктор, инициализирует хранилище.
     */
    public SimpleSet() {
        this.container = new DynamicArrayList<E>();
    }

    /**
     * Конструктор, инициализирует хранилище заданным размером.
     *
     * @param size заданный размер.
     */
    public SimpleSet(int size) {
        this.container = new DynamicArrayList<E>(size);
    }

    /**
     * Метод добавляет элемент в коллекцию, если он отсутствует.
     *
     * @param e вводимый в хранилище элемент.
     */
    public void add(E e) {
        if (!contains(e) && e != null) {
            this.container.add(e);
        }
    }

    /**
     * Метод выполняет проверку является ли элемент уникальным для коллекции.
     *
     * @param e проверяемое значение.
     * @return true - если значение присутствует,
     * false - если значение отсутствует.
     */
    private boolean contains(E e) {
        for (E current : this.container) {
            if (Objects.equals(current, e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает количество элементов в массиве.
     */
    public int size() {
        return container.size();
    }

    /**
     * Возвращает итератор для обхода коллекции.
     */
    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
