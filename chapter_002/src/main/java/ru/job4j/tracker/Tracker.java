package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс Tracker работает с заявками типа Item.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Добавление заявки.
     *
     * @param item новая заявка.
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Редактирование заявки.
     *
     * @param id   заданный id.
     * @param item заданная заявка.
     * @return true - заявка заменена, иначе false.
     */
    public boolean replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
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
        boolean result = false;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     *
     * @return список всех заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null) {
                result[i] = this.items[i];
            } else {
                result = null;
            }
        }
        return result;
    }

    /**
     * Получение заявки по id.
     *
     * @param id идентификатор заявки.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Получение списка по имени.
     *
     * @param key имя для поиска.
     * @return массив заявлок совпадающих по имени.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Генерация уникального ключа для заявки.
     *
     * @return
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
