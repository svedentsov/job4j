package ru.job4j.jmm.race;

public class ActionOne implements Runnable {

    public Counter counter;

    public ActionOne(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(1);
        }
    }
}
