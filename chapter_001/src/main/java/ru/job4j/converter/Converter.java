package ru.job4j.converter;

/**
 * Конвертер валют.
 */
public class Converter {
    /**
     * Конвертация рублей в евро.
     *
     * @param value рубли
     * @return евро
     */
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертация евро в рубли.
     *
     * @param value евро
     * @return рубли
     */
    public static int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертация рублей в доллары.
     *
     * @param value рубли
     * @return доллары
     */
    public static int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертация долларов в рубли
     *
     * @param value доллары
     * @return рубли
     */
    public static int dollarToRuble(int value) {
        return value * 60;
    }
}
