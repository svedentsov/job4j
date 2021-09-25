package ru.job4j.tracker;

/**
 * Класс реализует интерфейс Input.
 */
public class StubInput implements Input {
    private final ConsoleInput pseudo = new ConsoleInput();
    /**
     * содержит запрограммированную последовательность вводимых пользователем команд в консоль
     */
    private final String[] value;
    /**
     * счётчик продвижения методом ask по последовательности команд
     */
    private int position;

    /**
     * Конструктор, передающий в параметрах массив с предполагаемым набором команд пользователя.
     *
     * @param value последовательность команд
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.parseInt(this.ask(question));
        if (this.pseudo.isNotCorrect(key, range)) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
