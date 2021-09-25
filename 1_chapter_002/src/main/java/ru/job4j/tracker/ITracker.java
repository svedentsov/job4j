package ru.job4j.tracker;

import java.util.List;

/**
 * Шаблон для реализации классов трекера.
 */
public interface ITracker {
    default boolean init() {
        return true;
    }

    /**
     * Добавить заявку.
     *
     * @param item новая заявка
     * @return успешно добавленная заявка
     */
    Item add(Item item);

    /**
     * Редактировать заявку.
     *
     * @param id   уникальный ключ заменяемой заявки
     * @param item заменяющая заявка
     */
    boolean replace(String id, Item item);

    /**
     * Удалить заявку.
     *
     * @param id уникальный ключ удаляемой заявки
     */
    boolean delete(String id);

    /**
     * Получить список всех заявок.
     *
     * @return массив заявок
     */
    List<Item> findAll();

    /**
     * Получить список заявок с совпадающим именем.
     *
     * @param key имя искомых заявок
     * @return массив заявок совпадающих по имени
     */
    List<Item> findByName(String key);

    /**
     * Получить заявку по уникальному ключу.
     *
     * @param id уникальный ключ
     * @return заявка
     */
    Item findById(String id);

    /**
     * Очистить хранилище.
     */
    void clear();
}
