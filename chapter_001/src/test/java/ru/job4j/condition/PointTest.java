package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    @Test
    public void whenZeroAndTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
    }

    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }

    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }

    @Test
    public void distance1() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        double result = first.distance(second);
        assertThat(result, is(2.0));
    }

    @Test
    public void distance2() {
        Point first = new Point(2, 0);
        Point second = new Point(0, 0);
        double result = first.distance(second);
        assertThat(result, is(2.0));
    }

    @Test
    public void distance3() {
        Point first = new Point(4, 3);
        Point second = new Point(2, 1);
        double result = first.distance(second);
        assertThat(result, is(2.8284271247461903));
    }

    @Test
    public void distance4() {
        Point first = new Point(-1, 3, 3);
        Point second = new Point(6, 2, -2);
        double result = first.distance3d(second);
        assertThat(result, is(8.660254037844387));
    }

    @Test
    public void distance5() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(2, 0, 0);
        double result = first.distance3d(second);
        assertThat(result, is(2.0));
    }
}
