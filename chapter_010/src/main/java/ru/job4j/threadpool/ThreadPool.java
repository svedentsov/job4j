package ru.job4j.threadpool;

import ru.job4j.blockingqueue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks;

    private volatile boolean isStopped = false;

    public ThreadPool(SimpleBlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
        int sizeOfPool = Runtime.getRuntime().availableProcessors();
        System.out.println("sizeOfPool = " + sizeOfPool);

        for (int i = 0; i < sizeOfPool; i++) {
            Thread taskExecutor = new TaskExecutor(tasks);
            threads.add(taskExecutor);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void work(Runnable job) throws InterruptedException {
        if (isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        isStopped = true;
    }
}
