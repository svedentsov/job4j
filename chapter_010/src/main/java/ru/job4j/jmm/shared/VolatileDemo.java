package ru.job4j.jmm.shared;

public class VolatileDemo extends Thread {

    // Использование volatile гарантирует видимость переменной для всех потоков
    // Как только мы используем volatile, вечный цикл завершится,
    // будет использовано значение флага из основной памяти
    boolean keepRunning = true;

    @Override
    public void run() {
        long count = 0;
        while (keepRunning) {
            count++;
        }
        System.out.println("Thread terminated. " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        demo.start();
        Thread.sleep(1000);
        System.out.println("after sleeping in main");
        demo.keepRunning = false;
        demo.join();
        System.out.println("keepRunning set to " + demo.keepRunning);
    }
}
