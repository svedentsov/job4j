package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Static Field singleton
 * Lazy loading (ленивая загрузка)
 */
public class TrackerStaticField {
    private static Tracker instance;

    private TrackerStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
