package ru.job4j.ex;

public class Fact {
    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("n should be at least 1");
        }
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println(fact.calc(0));
    }
}
