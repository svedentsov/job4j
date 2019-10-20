package ru.job4j.sort;

import java.util.Arrays;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Merge {
    /**
     * Объединение двух отсортированных по возрастанию массивов в один.
     *
     * @param left  первый отсортированный массив.
     * @param right второй отсортированный массив.
     * @return итоговый массив.
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int first = 0;
        int second = 0;
        int index = 0;
        while (first < left.length && second < right.length) {
            if (left[first] < right[second]) {
                rsl[index] = left[first];
                first++;
            } else {
                rsl[index] = right[second];
                second++;
            }
            index++;
        }
        while (first < left.length) {
            rsl[index] = left[first];
            first++;
            index++;
        }
        while (second < right.length) {
            rsl[index] = right[second];
            second++;
            index++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
