package ru.job4j.calculator;

/**
 * Расчет идеального веса.
 */
public class Fit {
    /**
     * Идеальный вес для мужщины.
     *
     * @param height рост
     * @return идеальный вес
     */
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height рост
     * @return идеальный вес
     */
    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
