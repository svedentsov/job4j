package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <p> 1. Создайте в корне проекта файл even.txt.
 * <p> 2. В файл добавьте числа. Одно число на строку.
 * <p> 3. Создайте класс ru.job4j.io.EvenNumberFile с методом main.
 * <p> 4. В классе нужно прочитать файл even.txt. Для каждого числа проверить является ли оно четным числом. Ответ вывести на консоль.
 */
public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./2_chapter_002/src/main/resources/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }

            // Полученный текст разбивается на строки через метод split
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int i = Integer.parseInt(line);
                if (i % 2 == 0) {
                    System.out.println(String.format("%d - четное число", i));
                } else {
                    System.out.println(String.format("%d - нечетное число", i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
