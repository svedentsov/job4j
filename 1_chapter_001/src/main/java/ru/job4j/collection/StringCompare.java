package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int min = Math.min(l1, l2);
        for (int i = 0; i < min; i++) {
            int result = Character.compare(s1.charAt(i), s2.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return l1 - l2;
    }
}
