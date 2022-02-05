package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * В этом задании необходимо создать программу 'Консольный чат'.
 * - пользователь вводит слово-фразу, программа берет случайную фразу из текстового файла и выводит в ответ.
 * - программа замолкает если пользователь вводит слово «стоп», при этом он может продолжать отправлять сообщения в чат.
 * - если пользователь вводит слово «продолжить», программа снова начинает отвечать.
 * - при вводе слова «закончить» программа прекращает работу.
 * - запись диалога, включая слова-команды стоп/продолжить/закончить должны быть записаны в текстовый лог.
 */
public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String OUT = "закончить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /**
     * Реализация логики работы чата.
     */
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine = "";
            String answerBot;
            StringBuilder dialogText = new StringBuilder();
            boolean botAnswerMessage = true;
            List<String> answersList = getAnswersList();
            while (!(OUT.equals(inputLine))) {
                inputLine = br.readLine();
                dialogText.append(
                        String.format("User: %s%s", inputLine, System.lineSeparator())
                );
                if (STOP.equals(inputLine)) {
                    botAnswerMessage = false;
                }
                if (OUT.equals(inputLine) || CONTINUE.equals(inputLine)) {
                    botAnswerMessage = true;
                } else if (botAnswerMessage) {
                    int i = new Random().nextInt(answersList.size());
                    answerBot = String.format(
                            "Bot: %s%s", answersList.get(i), System.lineSeparator()
                    );
                    dialogText.append(answerBot);
                    System.out.println(answerBot);
                }
            }
            writeDataInFile(dialogText.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Прочитать файл с фразами и перенести данные в список.
     */
    public List<String> getAnswersList() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(botAnswers)))) {
            reader.lines().forEach(list::add);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    /**
     * Записать диалог между пользователем и ботом файл.
     */
    private void writeDataInFile(String dialogText) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            bufferedWriter.write(dialogText);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Доступны следующие действия:\n"
                + "1. Бот перестанет отвечать, введите: %s\n"
                + "2. Бот возобновит работу, введите: %s \n"
                + "3. Закончить работу с чатом, введите: %s \n%n", STOP, CONTINUE, OUT);
        ConsoleChat cc = new ConsoleChat(
                "chapter_006/data/botDialog.txt",
                "chapter_006/data/botAnswers.txt"
        );
        cc.run();
    }
}
