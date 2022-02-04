package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Используется как хранилище заявок.
 */
public class Tracker implements ITracker {
    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Для генерации уникального номера.
     */
    private static final Random RN = new Random();

    @Override
    public Item add(Item item) {
        item.setId(this.generateId());
        item.setCreate(System.currentTimeMillis());
        this.items.add(item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findPositionById(id);
        if (index != -1) {
            result = true;
            item.setId(id);
            item.setCreate(this.items.get(index).getCreate());
            this.items.set(index, item);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findPositionById(id);
        if (index != -1) {
            result = true;
            this.items.remove(index);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        return this.items;
    }

    @Override
    public List<Item> findByName(String key) {
        return this.items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(String id) {
        int index = this.findPositionById(id);
        return index != -1 ? this.items.get(index) : null;
    }
    /**
     * Сгенерировать уникальный ключ для заявки.
     *
     * @return уникальный ключ
     */
    private String generateId() {
        return String.valueOf((RN.nextInt() + System.currentTimeMillis()) % 100000000);
    }

    /**
     * Получить позицию заявки в массиве по её уникальному ключу.
     *
     * @param id уникальный ключ
     * @return позиция в массиве
     */
    private int findPositionById(String id) {
        return IntStream.range(0, this.items.size())
                .filter(index -> this.items.get(index).getId().equals(id))
                .findFirst().orElse(-1);
    }
}
