package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

public class ItemSortTest {
    @Test
    public void itemSortIncrease() {
        List<Item> input = Arrays.asList(
                new Item("2. Второй"),
                new Item("1. Первый"),
                new Item("3. Третий")
        );
        List<Item> expect = Arrays.asList(
                new Item("1. Первый"),
                new Item("2. Второй"),
                new Item("3. Третий")
        );
        input.sort(new ItemSortName());
        assertThat(input.toString(), is(expect.toString()));
    }

    @Test
    public void itemSortReversed() {
        List<Item> input = Arrays.asList(
                new Item("2. Второй"),
                new Item("1. Первый"),
                new Item("3. Третий")
        );
        List<Item> expect = Arrays.asList(
                new Item("3. Третий"),
                new Item("2. Второй"),
                new Item("1. Первый")
        );
        input.sort(new ItemSortName().reversed());
        assertThat(input.toString(), is(expect.toString()));
    }
}
