package ru.job4j.jmm.race;

public class ActionTwo extends Thread {

    public Counter counter;

    public ActionTwo(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(100);
        }
    }
}
