package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double in = 170;
        double expected = 80.5;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0);
    }

    @Test
    public void womanWeight() {
        double in = 161;
        double expected = 58.65;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0);
    }
}
