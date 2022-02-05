package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConverterTest {
    @Test
    public void rubleToEuro() {
        int result = new Converter().rubleToEuro(140);
        assertThat(result, is(2));
    }

    @Test
    public void rubleToDollar() {
        int result = new Converter().rubleToDollar(300);
        assertThat(result, is(5));
    }

    @Test
    public void dollarToRuble() {
        int result = new Converter().dollarToRuble(7);
        assertThat(result, is(420));
    }

    @Test
    public void euroToRuble() {
        int result = new Converter().euroToRuble(6);
        assertThat(result, is(420));
    }
}
