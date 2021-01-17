package ru.job4j.condition;

/**
 * Вычисление площади треугольника через полупериметр.
 * Используем подготовленный ранее класс Point для вычисления расстояний между точками.
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * Формула (a + b + c) / 2
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + bc > ac) && (ab + ac > bc) && (bc + ac > ab);
    }

    /**
     * Метод вычисляет площадь треугольника по формуле: √ p *(p - a) * (p - b) * (p - c).
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return площадь треугольника, если он существует, иначе -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distance(this.b);
        double ac = this.b.distance(this.c);
        double bc = this.a.distance(this.c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
