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

    /**
     * Конструктор принимающий координаты объекта "точка".
     *
     * @param first  координата x.
     * @param second координата y.
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(0, 0);
        double result = first.distance(second);
//        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);
        Point first2 = new Point(2, 0);
        Point second2 = new Point(0, 0);
        double result2 = first2.distance(second2);
//        double result2 = distance(2, 0, 0, 0);
        System.out.println("result (2, 0) to (0, 0) " + result2);
    }
}
