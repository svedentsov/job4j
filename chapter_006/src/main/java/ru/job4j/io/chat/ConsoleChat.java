package ru.job4j.io.chat;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Класс определяет работу консольного чата.
 */
public class ConsoleChat {
    private static final String STOP = "стоп";
    private static final String FINISH = "завершить";
    private static final String CONTINUE = "продолжить";
    private static final String ANSWERS_FILE_NAME = "consoleChatAnswers.txt";
    /**
     * Состояние чата.
     * 0 - чат активен. На сообщения пользователя будет получен ответ.
     * 1 - Чат не активен. На сообщения пользователя не будет получен ответ.
     */
    private boolean responseState = true;
    /**
     * Режим работы чата.
     */
    private boolean chatState = true;
    /**
     * Список возможных ответов в чат.
     */
    private List<String> text;

    public ConsoleChat(List<String> text) {
        this.text = text;
    }

    /**
     * Цикл чата, проходит опрос пользователя и получение ответа из списка.
     *
     * @param user   ответ от пользователя
     * @param logger запись диалога в txt-файл
     */
    private void chatLoop(User user, Logger logger) {
        System.out.println("Вы запустили консольный чат.");
        System.out.println("Что бы остановить чат введите: " + STOP);
        System.out.println("Что бы продолжить чат введите: " + CONTINUE);
        System.out.println("Что бы завершить чат введите: " + FINISH);
        System.out.println("Пожалуйста введите слово-фразу, чтобы начать чат:");
        do {
            String answerUser = user.answer();
            statusCheck(answerUser);
            String answerChat = randomAnswer();
            if (!answerChat.equals("")) {
                System.out.println(answerChat);
            }
            logger.writeLog(answerUser, answerChat);
        } while (this.chatState);
    }

    /**
     * Метод проверяет режим чата и изменяет его активности.
     *
     * @param answer сообщение от пользователя
     */
    private void statusCheck(String answer) {
        if (STOP.equals(answer)) {
            this.chatState = true;
            this.responseState = false;
        }
        if (FINISH.equals(answer)) {
            System.out.println("Чат закрыт.");
            this.chatState = false;
        }
        if (CONTINUE.equals(answer)) {
            this.chatState = true;
            this.responseState = true;
        }
    }

    /**
     * Метод возвращающий случайную строку из текстового файла.
     */
    private String randomAnswer() {
        String result = "";
        if (this.chatState && this.responseState) {
            int number = new Random().nextInt(this.text.size());
            result = this.text.get(number);
        }
        return result;
    }

    public static void main(String[] args) {
        UserAnswer userAnswer = new UserAnswer();
        LoggerChat logger = new LoggerChat("log.txt");
        ReadTxt txt = new ReadTxt((Objects.requireNonNull(ReadTxt.class.getClassLoader().getResource(ANSWERS_FILE_NAME))).getFile());
        ConsoleChat chat = new ConsoleChat(txt.readFile());
        chat.chatLoop(userAnswer, logger);
    }
}
