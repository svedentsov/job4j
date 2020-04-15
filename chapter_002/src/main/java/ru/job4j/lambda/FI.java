package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        // Сортировать вложения по убыванию длины.
        Comparator<Attachment> comparatorDesc = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return right.getSize() - left.getSize();
        };
        Arrays.sort(atts, comparatorDesc);

        String[] strings = {"23", "123", "84", "0", "90"};
        // Сортировать строки по возрастанию длины.
        Comparator<String> cmpSizeAsc = (left, right) -> left.length() - right.length();
        Arrays.sort(strings, cmpSizeAsc);
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Сортировать строки по убыванию длины.
        Comparator<String> cmpSizeDesc = (left, right) -> right.length() - left.length();
        Arrays.sort(strings, cmpSizeDesc);
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Сортировать строки по лексическому сравнению.
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(strings, cmpText);
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}