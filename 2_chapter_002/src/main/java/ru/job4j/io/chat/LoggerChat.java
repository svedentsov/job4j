package ru.job4j.io.chat;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Класс записывает сообщения из чата в файл log.txt.
 */
public class LoggerChat implements Logger {
    private String path;

    public LoggerChat(String path) {
        this.path = path;
    }

    @Override
    public void writeLog(String user, String chat) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(this.path, true)))) {
            out.println("User - " + user);
            if (!chat.equals("")) {
                out.println("Chat - " + chat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
