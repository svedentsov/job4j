package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Static final field singleton
 * Eager loading (энергичная загрузка)
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerStaticFinalField {

    private static final Tracker INSTANCE = new Tracker();

    private TrackerStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
