package ru.job4j.calculator;

/**
 * Элементарный калькулятор: сложение, вычитание, умножение, деление.
 */
public class Calculator {
    private double result;

    /**
     * Метод сложения чисел
     *
     * @param first  первое число
     * @param second второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод вычитания чисел.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод умножения чисел.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод деления чисел.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод возврата результата.
     *
     * @return результат действия
     */
    public double getResult() {
        return this.result;
    }
}
