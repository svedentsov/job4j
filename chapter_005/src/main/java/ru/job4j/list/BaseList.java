package ru.job4j.list;

public interface BaseList<E> extends Iterable<E> {

    boolean add(E value);

    E get(int index);

    E[] ensureCapacity();
}
