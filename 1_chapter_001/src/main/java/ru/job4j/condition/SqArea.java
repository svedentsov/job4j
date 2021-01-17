package ru.job4j.condition;

public class SqArea {
    public static int square(int p, int k) {
        int height = p / (2 * (k + 1));
        int width = height * k;
        return width * height;
    }
}
