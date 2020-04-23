package ru.job4j.stragery;

/**
 * Класс Square для рисования квадрата.
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}
