package ru.job4j.generic;

/**
 * Базовый абстрактны класс Base.
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
     * Получить идентификатор.
     *
     * @return идентификатор.
     */
    public String getId() {
        return id;
    }
}
