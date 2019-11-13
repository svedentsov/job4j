package ru.job4j.tracker;

/**
 * Класс StubInput реализует интерфейс Input.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
