package ru.job4j.calculator;

/**
 * Класс содержит методы для выполнения сложения, вычитания, умножения и деления.
 */
public class Calculator {
    /**
     * Метод производит операцию сложения first и second и выводит результат в консоль.
     *
     * @param first
     * @param second
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * Метод производит операцию деления first на second и выводит результат в консоль.
     *
     * @param first
     * @param second
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Метод производит операцию умножения first на second и выводит результат в консоль.
     *
     * @param first
     * @param second
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Метод производит операцию вычитания second из first и выводит результат в консоль.
     *
     * @param first
     * @param second
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Method main
     *
     * @param args args.
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}