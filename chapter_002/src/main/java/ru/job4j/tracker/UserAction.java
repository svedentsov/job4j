package ru.job4j.tracker;

/**
 * Интерфейс UserAction.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
