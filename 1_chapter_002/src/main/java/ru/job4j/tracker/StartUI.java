package ru.job4j.tracker;

/**
 * Точка входа в программу. Обеспечивает полноценную работу приложения.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final ITracker tracker;
    private boolean ready = true;

    /**
     * Конструктор, инициализирующий финальные поля.
     *
     * @param input   ввод данных от пользователя
     * @param tracker хранилище заявок
     */
    public StartUI(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void finish() {
        this.ready = false;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        int[] range = menu.getRange();
        do {
            menu.show();
            menu.select(this.input.ask("select:", range));
        } while (this.ready);
    }

    /**
     * Запуск программы.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
