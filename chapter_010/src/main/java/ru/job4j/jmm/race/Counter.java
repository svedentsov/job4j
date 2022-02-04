package ru.job4j.jmm.race;

public class Counter {

    public int count;

    // Два потока используют общий ресурс - один объект типа счетчик и одновременно меняют его состояние.
    // Чтобы уйти от состояния гонки, нужно синхронизировать код в критической секции,
    // в нашем случае синхронизируем метод экземпляра.
    public void add(int value) {
        int temp = count;
        this.count = this.count + value;
        System.out.println(String.format("thread %s: %s + %s = %s", Thread.currentThread().getName(), temp, value, count));
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread a = new Thread(new ActionOne(counter), "A");
        Thread b = new Thread(new ActionTwo(counter), "B");

        a.start();
        b.start();
    }
}
