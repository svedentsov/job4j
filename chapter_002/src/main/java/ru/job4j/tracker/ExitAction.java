package ru.job4j.tracker;

/**
 * Класс CreateAction. Добавление заявки.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit Program ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
