package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        double expected = 2;
        double out = Point.distance(0, 0, 2, 0);
        Assert.assertEquals(expected, out, 0);
    }

    @Test
    public void distance2() {
        double expected = 2;
        double out = Point.distance(2, 0, 0, 0);
        Assert.assertEquals(expected, out, 0);
    }

    @Test
    public void distance3() {
        double expected = 2.8284271247461903;
        double out = Point.distance(4, 3, 2, 1);
        Assert.assertEquals(expected, out, 0);
    }
}
