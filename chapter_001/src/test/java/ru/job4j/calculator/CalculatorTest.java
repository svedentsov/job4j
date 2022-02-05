package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {
    @Test
    public void whenAddFourPlusTwoThenSix() {
        double result = new Calculator().add(4, 2).getResult();
        assertThat(result, is(6.0));
    }

    @Test
    public void whenSubtractTwoMinusOneThenOne() {
        double result = new Calculator().subtract(2, 1).getResult();
        assertThat(result, is(1.0));
    }

    @Test
    public void whenDivNineByThreeThenThree() {
        double result = new Calculator().div(9, 3).getResult();
        assertThat(result, is(3.0));
    }

    @Test
    public void whenMultipleTwoToSevenThenFourteen() {
        double result = new Calculator().multiply(2, 7).getResult();
        assertThat(result, is(14.0));
    }
}
