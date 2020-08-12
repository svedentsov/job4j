package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Модульные тесты класса SimpleArray.java.
 */
public class SimpleArrayTest {
    @Test
    public void whenTryAddValuesToTheSimpleArrayShouldCheckThatAddedCorrect() {
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "first value";
        list.add(expected);
        String actual = list.get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenTryUpdateSomeValueInListShouldCheckThatValueIsUpdate() {
        SimpleArray<String> list = new SimpleArray<>();
        String expected = "Updated!";
        list.add("Not update!");
        list.update(0, expected);
        String actual = list.get(0);
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryUpdateUseBadPositionShouldCheckThatMethodUpdateThrowException() {
        SimpleArray<String> list = new SimpleArray<>();
        list.get(-1);
    }

    @Test
    public void whenTryAddNewValueToTheListButListIsFullShouldCheckThatListIsResize() {
        SimpleArray<String> list = new SimpleArray<>(2);
        int expected = 4;
        list.add("one");
        list.add("two");
        list.add("three");
        int actual = list.size();
        assertThat(actual, is(expected));
    }

    @Test
    public void whenTryDeleteValueFromListShouldCheckThatValueWasRemoved() {
        SimpleArray<String> list = new SimpleArray<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.delete(1);
        String actual = list.get(1);
        assertThat(actual, is(nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryDeleteElementUsingBadPositionShouldCheckThatMethodThrowException() {
        SimpleArray<String> list = new SimpleArray<>();
        list.delete(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryUpdateElementWithNegativeIndexShouldCheckThatListThrowException() {
        SimpleArray<String> string = new SimpleArray<>();
        string.update(-1, "new string");
    }
}
