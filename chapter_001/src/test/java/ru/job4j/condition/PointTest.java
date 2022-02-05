package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PointTest {
    @Test
    public void distance1() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double result = a.distance(b);
        assertThat(result, is(2.0));
    }

    @Test
    public void distance2() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 0);
        double result = a.distance(b);
        assertThat(result, is(2.0));
    }

    @Test
    public void distance3() {
        Point a = new Point(4, 3);
        Point b = new Point(2, 1);
        double result = a.distance(b);
        assertThat(result, is(2.8284271247461903));
    }

    @Test
    public void distance4() {
        Point a = new Point(-1, 3, 3);
        Point b = new Point(6, 2, -2);
        double result = a.distance3d(b);
        assertThat(result, is(8.660254037844387));
    }

    @Test
    public void distance5() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 0, 0);
        double result = a.distance3d(b);
        assertThat(result, is(2.0));
    }
}
