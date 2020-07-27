package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        // Понижающее приведение (down casting)
        Student student = freshman;
        Object object = freshman;
    }
}
