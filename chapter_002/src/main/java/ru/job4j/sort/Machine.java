package ru.job4j.sort;

import java.util.Arrays;

/**
 * Расчет сдачи в кофе-машине.
 */
public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] result = new int[100];
        int size = 0;
        int change = money - price;
        for (int coin : coins) {
            while (change >= coin) {
                change = change - coin;
                result[size] = coin;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }
}
