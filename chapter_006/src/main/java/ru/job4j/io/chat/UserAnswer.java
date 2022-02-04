package ru.job4j.io.chat;

import java.util.Scanner;

/**
 * Класс считывает информацию введенную пользователем.
 */
public class UserAnswer implements User {
    @Override
    public String answer() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
