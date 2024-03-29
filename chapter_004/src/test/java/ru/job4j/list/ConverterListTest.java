package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterListTest {
    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>(
                List.of(
                        new int[]{1},
                        new int[]{2, 3}
                )
        );
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), Is.is(expect));
    }

    @Test
    public void whenThreeList() {
        List<int[]> in = new ArrayList<>(
                List.of(
                        new int[]{1, 2, 3},
                        new int[]{4},
                        new int[]{5, 6}
                )
        );
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(ConvertList.convert(in), Is.is(expect));
    }
}
