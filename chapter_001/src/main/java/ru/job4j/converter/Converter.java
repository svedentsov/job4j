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
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертация евро в рубли.
     *
     * @param value евро
     * @return рубли
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертация рублей в доллары.
     *
     * @param value рубли
     * @return доллары
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертация долларов в рубли
     *
     * @param value доллары
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}
