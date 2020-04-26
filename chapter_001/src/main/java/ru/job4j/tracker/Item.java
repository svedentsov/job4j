package ru.job4j.tracker;

/**
 * Заявка.
 */
public class Item implements Comparable<Item> {
    private String id;
    private String name;

    /**
     * Конструктор.
     *
     * @param name имя заявки
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Задать id заявки.
     *
     * @param id id заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Получить id заявки.
     *
     * @return id заявки
     */
    public String getId() {
        return id;
    }

    /**
     * Задать имя заявки.
     *
     * @param name имя заявки
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить имя заявки.
     *
     * @return имя заявки
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(Item another) {
        return name.compareTo(another.getName());
    }
}
