package ru.job4j.tracker;

/**
 * Интерфейс Input.
 */
public interface Input {

    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
