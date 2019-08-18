package ru.job4j.calculator;

public class Fit {

    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(170);
        System.out.println("Man 170 is " + man);
        double woman = womanWeight(161);
        System.out.println("Woman 161 is " + woman);
    }
}
