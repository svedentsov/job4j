package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        int annualPayment = monthly * 12;
        int annualPercentage = (int) (amount * percent / 100);
        while (amount > 0) {
            amount = amount + annualPercentage - annualPayment;
            year++;
        }
        return year;
    }
}
