package ru.job4j.poly;

/**
 * Класс Bus реализует интерфейс Transport.
 */
public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Транспорт поехал.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество человек в транспорте: " + count);
    }

    @Override
    public double refuel(int gas) {
        return gas * 45.51;
    }
}
