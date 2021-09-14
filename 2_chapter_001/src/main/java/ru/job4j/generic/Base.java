package ru.job4j.generic;

/**
 * Абстрактный класс для моделей c методами String getId().
 */
public abstract class Base {
    /**
     * Уникальный идентификатор.
     */
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
