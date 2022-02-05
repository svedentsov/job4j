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
    public Calculator add(double first, double second) {
        this.result = first + second;
        return this;
    }

    /**
     * Вычесть числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public Calculator subtract(double first, double second) {
        this.result = first - second;
        return this;
    }

    /**
     * Умножить числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public Calculator multiply(double first, double second) {
        this.result = first * second;
        return this;
    }

    /**
     * Поделить числа.
     *
     * @param first  первое число
     * @param second второе число
     */
    public Calculator div(double first, double second) {
        this.result = first / second;
        return this;
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
