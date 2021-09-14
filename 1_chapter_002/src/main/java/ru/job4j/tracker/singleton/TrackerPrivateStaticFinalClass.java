package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Private static final class singleton
 * Lazy loading (ленивая загрузка)
 */
public class TrackerPrivateStaticFinalClass {
    private TrackerPrivateStaticFinalClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}
