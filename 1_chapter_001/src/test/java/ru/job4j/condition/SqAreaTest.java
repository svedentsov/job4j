package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square1() {
        int expected = 1;
        int out = SqArea.square(4, 1);
        Assert.assertEquals(expected, out, 0);
    }

    @Test
    public void square2() {
        int expected = 2;
        int out = SqArea.square(6, 2);
        Assert.assertEquals(expected, out, 0);
    }
}
