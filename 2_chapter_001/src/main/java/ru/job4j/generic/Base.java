package ru.job4j.generic;

/**
 * Абстрактный класс для моделей c методами String getId().
 */
public abstract class Base {
    /**
     * Уникальный идентификатор.
     */
    private final String id;

    /**
     * Конструктор по умолчанию.
     *
     * @param id идентификатор.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Получить id модели, добавленной в массив.
     *
     * @return идентификатор.
     */
    public String getId() {
        return this.id;
    }
}
