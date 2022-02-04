package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Что такое Socket?
 * Задание.
 * Доработайте класса ru.job4j.io.EchoServer.
 * Если клиент отправляет запрос http://localhost:9000/?msg=Bye нужно завершить работу сервера.
 * <p>
 * Бот (работающий по протоколу HTTP)
 * Сервер, представляет собой, простого бота, который реагирует на команды клиента передаваемые в виде Get запроса.
 * Задание 2.
 * В этом задании Вам нужно доработать класс ru.job4j.io.EchoServer.
 * Клиент отправляет запросы, сервер должен ему отвечать.
 * 1. Ответить "msg=Hello" (http://localhost:9000/?msg=Hello)
 * 2. Завершить работу сервера "msg=Exit" (http://localhost:9000/?msg=Exit)
 * 3. Во всех остальных случаях отправлять текст запроса "msg=Any"
 * Запрос с параметром What, должен вернуть ответ типа What (http://localhost:9000/?msg=What)
 * <p>
 * Slf4j - вывод exception.
 * Задание 3.
 * В задании Сокет/Бот уберите из сигнатуры метода main исключение.
 * Обработайте его через catch c выводом в логгер.
 */
public class EchoServer {

    private static final String END = "exit";
    private static final String HELLO = "hello";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                     PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                    String str;
                    String msg = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.startsWith("GET /?msg=")) {
                            msg = (str.split(" ")[1]).substring(6);
                        }
                        if (msg.equalsIgnoreCase(END)) {
                            msg = ("Server closing");
                            server.close();
                        }
                        if (msg.equalsIgnoreCase(HELLO)) {
                            msg = "Hello, dear friend!";
                        }
                    }
                    out.println("HTTP/1.1 200 OK\r\n");
                    out.println(msg);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
