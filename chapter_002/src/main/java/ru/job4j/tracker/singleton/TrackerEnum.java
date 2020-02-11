package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * Enum singleton
 * Eager loading (энергичная загрузка)
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public enum TrackerEnum {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}
