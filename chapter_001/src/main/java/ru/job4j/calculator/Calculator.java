package ru.job4j.calculator;

/**
 * Элементарный калькулятор: сложение, вычитание, умножение, деление.
 */
public class Calculator {

    private double result;

    /**
     * Сложить числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычесть числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Умножить числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Поделить числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Получить результат.
     *
     * @return результат действия
     */
    public double getResult() {
        return this.result;
    }
}
