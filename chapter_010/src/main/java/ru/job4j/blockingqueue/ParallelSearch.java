package ru.job4j.blockingqueue;

/**
 * В этом задании нужно разработать механизм остановки потребителя, когда производитель закончил свою работу.
 * <p>
 * Представим утилиту по поиску текста в файловой системе.
 * Одна нить ищет файлы с подходящим именем. Вторая нить берет эти файлы и читает.
 * Это схема хорошо описывается шаблон Producer Consumer. Однако есть один момент.
 * Когда первая нить заканчивает свою работу, потребители переходят в режим wait.
 * И утилита работает вечно.
 * Давайте составим упрощенный код такой программы.
 * <p>
 * Если мы запустим этот код. то на консоли мы увидим. что нить производитель закончила работу, а нить потребитель продолжает ждать событий.
 * Ваша задача изменить код, так чтобы потребитель завершал свою работу.
 * Код нужно изменить в методе main.
 */
public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted() || !queue.isEmpty()) {
                        try {
                            queue.poll();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();

        final Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        try {
                            queue.offer(index);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    consumer.interrupt();
                }
        );
        producer.start();
    }
}
