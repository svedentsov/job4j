package ru.job4j.tracker;

/**
 * Интерфейс Input.
 */
public interface Input {
    /**
     * Выводит в консоль переданную строку, возвращает полученный на неё ответ от пользователя.
     *
     * @param question строка в консоль
     * @return строка из консоли
     */
    String ask(String question);

    int ask(String question, int[] range);
}