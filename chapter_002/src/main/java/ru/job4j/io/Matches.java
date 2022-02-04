package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        System.out.println("На столе " + matches + " спичек.");
        int count = 0;
        while (matches > 0) {
            if (count % 2 == 0) {
                System.out.println("Первый игрок. Введите число от 1 до 3: ");
            } else {
                System.out.println("Второй игрок. Введите число от 1 до 3: ");
            }
            count++;
            int amount = Integer.parseInt(input.nextLine());
            if (amount < 1 || amount > 3) {
                System.out.println("Указано неправильное чило. Введите от 1 до 3.");
                continue;
            }
            matches = matches - amount;
            if (matches < 1) {
                System.out.println("Игра завершена. Спичек не осталось.");
                break;
            }
            System.out.println("На столе осталось " + matches + " спички(ек)");
        }
    }
}
