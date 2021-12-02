package ru.job4j.io.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Бот - мудрый Оракл. Клиентская сторона.
 */
public class Client {
    /**
     * Сокет.
     */
    private final Socket socket;
    /**
     * Номер порта.
     */
    private static final int PORT = 1111;
    /**
     * IP адрес.
     */
    private static final String IP = "127.0.0.1";

    /**
     * Конструктор.
     *
     * @param socket сокет
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Реализация клиентской части бота.
     * Пользователь вводит данные в консоли и получает ответ с сервера.
     * Сервер может отправлять большие сообщения. Чтобы понять, когда конец сообщения, он отправляет пустую строку.
     * Оракл отвечает на приветствие Hello Oracle.
     * Если Ораклу сказали Exit, то приложение выключается.
     * На любую другую слово-фразу, сервер отвечает I don't understand you.
     */
    public void start() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             Scanner console = new Scanner(System.in);
        ) {
            String ask;
            String answer;
            do {
                ask = console.nextLine();
                out.println(ask);
                if (!"Exit".equals(ask)) {
                    answer = in.readLine();
                    while (!answer.isEmpty()) {
                        System.out.println(answer);
                        answer = in.readLine();
                    }
                }
            } while (!"Exit".equals(ask));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
