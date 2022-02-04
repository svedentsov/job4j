package ru.job4j.pool;

import ru.job4j.blockingqueue.SimpleBlockingQueue;

public class TaskExecutor extends Thread {

    private SimpleBlockingQueue<Runnable> taskQueue;

    public TaskExecutor(SimpleBlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() || !taskQueue.isEmpty()) {
            try {
                Runnable task = taskQueue.poll();
                task.run();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
