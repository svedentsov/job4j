package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Enum singleton
 * Eager loading (энергичная загрузка)
 */
public enum TrackerEnum {
    INSTANCE;
    private static final Tracker TRACKER = new Tracker();

    public Tracker getTracker() {
        return TRACKER;
    }
}
