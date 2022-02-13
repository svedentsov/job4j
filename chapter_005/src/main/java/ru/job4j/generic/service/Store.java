package ru.job4j.generic.service;

import ru.job4j.generic.model.Base;

/**
 * Интерфейс описывает контейнеры для хранения объектов.
 */
public interface Store<T extends Base> {
    /**
     * Добавить новый объект в хранилище.
     * Объект должен быть наследником класса Base.
     *
     * @param model объект типа Base.
     */
    void add(T model);

    /**
     * Заменить объект хранилища на другой.
     *
     * @param id    ID заменяемого объекта.
     * @param model новый объект для записи в хранилище на место старого.
     * @return true значение заменено, иначе false.
     */
    boolean replace(String id, T model);

    /**
     * Удаление объекта из хранилища.
     *
     * @param id ID удаляемого объекта.
     * @return true объект удален, иначе false.
     */
    boolean delete(String id);

    /**
     * Найти объект в хранилище.
     *
     * @param id идентификатор элемента.
     * @return найденный объект, либо null если он отсутствует.
     */
    T findById(String id);
}
