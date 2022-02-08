package ru.job4j.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static final String SUBJECT_TEMPLATE = "Notification %1$s to email %2$s";
    private static final String BODY_TEMPLATE = "body = Add a new event to %1$s";

    /**
     * Отправляет почту через ExecutorService, формирует тему и содержание письма,
     * добавляет задачу по отправке уведомления в пул и сразу ее выполняет.
     *
     * @param user объект пользователь.
     */
    public void emailTo(User user) {
        String subject = String.format(SUBJECT_TEMPLATE, user.getUsername(), user.getEmail());
        String body = String.format(BODY_TEMPLATE, user.getUsername());

        this.pool.submit(() -> {
            System.out.println("Execute " + Thread.currentThread().getName());
            send(subject, body, user.getEmail());
        });
    }

    /**
     * выполняет отправку письма с указанными параметрами.
     *
     * @param subject тема.
     * @param body    содержание.
     * @param email   адрес получателя.
     */
    public void send(String subject, String body, String email) {
        System.out.println("subject: " + subject);
        System.out.println("body: " + body);
        System.out.println("email: " + email);
        System.out.println();
    }

    /**
     * shutdown() упорядоченно завершает работу пула,
     * при этом ранее отправленные задачи выполняются, а новые задачи не принимаются с помощью isTerminated() проверяем,
     * все-ли задачи исполнителя сервиса завершены по команде остановки shutdown()
     */
    public void close() {
        this.pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EmailNotification notification = new EmailNotification();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                notification.emailTo(new User("user " + i, "user" + i + "@mail.com"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notification.close();
    }
}
