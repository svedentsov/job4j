package ru.job4j.tracker;

/**
 * Интерфейс Input
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
