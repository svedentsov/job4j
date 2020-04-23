package ru.job4j.tracker;

/**
 * Объект класса Item хранит заявку.
 */
public class Item implements Comparable<Item> {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

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
