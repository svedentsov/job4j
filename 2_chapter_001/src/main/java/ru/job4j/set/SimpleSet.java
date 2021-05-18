package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

/**
 * 1. Реализовать коллекцию Set на массиве.
 * Коллекция должна обеспечивать void add(E e) и реализовывать Iterable<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 * <p>
 * Контейнер типа Set, позволяющий хранить только уникальные значения элементов.
 * Реализован на базе массивов.
 */
public class SimpleSet<E> implements Iterable<E> {

    /**
     * Хранилище элементов на базе массива.
     */
    private SimpleArrayList<E> container;

    /**
     * Конструктор, инициализирует хранилище.
     */
    public SimpleSet() {
        this.container = new SimpleArrayList<E>();
    }

    /**
     * Конструктор, инициализирует хранилище заданным размером.
     *
     * @param size заданный размер.
     */
    public SimpleSet(int size) {
        this.container = new SimpleArrayList<E>(size);
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
