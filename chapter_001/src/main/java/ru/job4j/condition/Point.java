package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;
    private int z;

    /**
     * Конструктор принимающий координаты точки в 2-х пространствах.
     *
     * @param x координата x.
     * @param y координата y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор принимающий координаты точки в 3-х пространствах.
     *
     * @param x координата x.
     * @param y координата y.
     * @param z координата z.
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(0, 0);
        double result = first.distance(second);
        System.out.println("result (0, 0) to (2, 0) " + result);
        Point first2 = new Point(2, 0);
        Point second2 = new Point(0, 0);
        double result2 = first2.distance(second2);
        System.out.println("result (2, 0) to (0, 0) " + result2);
    }
}
