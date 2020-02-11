package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Private static final class singleton
 * Lazy loading (ленивая загрузка)
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerPrivateStaticFinalClass {

    private TrackerPrivateStaticFinalClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}
