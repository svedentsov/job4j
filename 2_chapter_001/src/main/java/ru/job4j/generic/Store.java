package ru.job4j.generic;

import java.util.Iterator;

/**
 * Интерфейс описывает контейнеры для хранения объектов.
 */
public interface Store<T extends Base> {
    /**
     * Метод добавляет указанный элемент массива.
     *
     * @param model элемент
     */
    void add(T model);

    /**
     * Метод заменяет элемент указанным элемент массива.
     *
     * @param id    идентификатор заменяемого объекта
     * @param model новый элемент
     * @return true - значение заменено, иначе false
     */
    boolean replace(String id, T model);

    /**
     * Удалить элемент массива, определяя его индекс по id.
     *
     * @param id идентификатор удаляемого элемента.
     * @return true - элемент удален, иначе - false.
     */
    boolean delete(String id);

    /**
     * Метод находит элемент типа T по id.
     *
     * @param id идентификатор элемента.
     * @return найденный элемент.
     */
    T findById(String id);

    /**
     * return Итератор хранилища.
     */
    Iterator<T> iter();
}
