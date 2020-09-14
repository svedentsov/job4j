package ru.job4j.generic;

import java.util.Iterator;

/**
 * Интерфейс описывает контейнеры для хранения объектов.
 */
public interface Store<T extends Base> {
    /**
     * Добавить элемент.
     *
     * @param model элемент
     */
    void add(T model);

    /**
     * Заменить элемент.
     *
     * @param id    идентификатор заменяемого элемента
     * @param model новый элемент
     * @return true - значение заменено, иначе - false
     */
    boolean replace(String id, T model);

    /**
     * Удалить элемент.
     *
     * @param id идентификатор удаляемого элемента.
     * @return true - элемент удален, иначе - false.
     */
    boolean delete(String id);

    /**
     * Найти элемент по идентификатору.
     *
     * @param id идентификатор элемента.
     * @return найденный элемент.
     */
    T findById(String id);

    Iterator<T> iter();
}
