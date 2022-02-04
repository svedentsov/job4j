package ru.job4j.tracker;

/**
 * Пользовательское действие, возможное при работе с программой Трекер.
 */
public interface UserAction {
    /**
     * Получить ключ для запуска действия.
     *
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     *
     * @param input   получение данных от пользователя
     * @param tracker хранилище заявок
     */
    void execute(Input input, ITracker tracker);

    /**
     * Получить информацию о данном пользовательском действии.
     *
     * @return строка меню
     */
    String info();
}
