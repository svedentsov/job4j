package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс Tracker. Работает с заявками.
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Добавление заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Замена заявки в хранилище.
     *
     * @param id   id заявки.
     * @param item новая заявка.
     * @return true - заявка заменена, иначе false.
     */
    public boolean replace(String id, Item item) {
        for (int i = 0; i != this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                item.setId(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Удаление заявки.
     *
     * @param id название заявки.
     * @return true если заявка удалена, иначе false.
     */
    public boolean delete(String id) {
        Item item = findById(id);
        return items.remove(item);
    }

    /**
     * Получить все заявки.
     *
     * @return список всех заявок.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Поиск заявки по id.
     *
     * @param id идентификатор заявки.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Поиск заявок по имени.
     *
     * @param key имя для поиска.
     * @return массив заявлок совпадающих по имени.
     */
    public List<Item> findByName(String key) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    /**
     * Генерация уникального ключа заявки.
     *
     * @return уникальный ключ
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
