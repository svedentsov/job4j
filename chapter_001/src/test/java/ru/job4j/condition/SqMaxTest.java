package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqMaxTest {
    @Test
    public void whenMaxFirst() {
        int result = new SqMax().max(12, 5, 2, 1);
        int expected = 12;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxSecond() {
        int expected = 5;
        int result = new SqMax().max(3, 5, 1, 2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxThird() {
        int expected = 11;
        int result = new SqMax().max(3, 5, 11, 2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxThird2() {
        int expected = 11;
        int result = new SqMax().max(8, 5, 11, 2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxForth() {
        int expected = 21;
        int result = new SqMax().max(3, 5, 11, 21);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxAll() {
        int expected = 23;
        int result = new SqMax().max(23, 23, 23, 23);
        Assert.assertEquals(expected, result);
    }
}