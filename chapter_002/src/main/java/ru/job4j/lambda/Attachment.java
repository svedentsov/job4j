package ru.job4j.lambda;

/**
 * Вложение.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Attachment {
    /**
     * Имя вложения.
     */
    private String name;
    /**
     * Размер вложения.
     */
    private int size;

    /**
     * Конструктор вложения.
     *
     * @param name имя вложения.
     * @param size размер вложения.
     */
    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Получить имя вложения.
     *
     * @return имя вложения.
     */
    public String getName() {
        return name;
    }

    /**
     * Получить размер вложения.
     *
     * @return размер вложения.
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{" + "name='" + name + '\'' + ", size=" + size + '}';
    }
}
