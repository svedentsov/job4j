package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Используется для ввода пользовательских данных из консоли.
 */
public class ConsoleInput implements Input {
    /**
     * объект для считывания данных с консоли
     */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        if (isNotCorrect(key, range)) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }

    public boolean isNotCorrect(int key, int[] range) {
        boolean exist = true;
        for (int value : range) {
            if (value == key) {
                exist = false;
                break;
            }
        }
        return exist;
    }
}