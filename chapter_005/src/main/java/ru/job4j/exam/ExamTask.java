package ru.job4j.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamTask {
    /**
     * Сравнить состоят ли два слова из одинаковых символов.
     *
     * @param s1 первое слово.
     * @param s2 второе слово.
     * @return true, если два слова из одинаковых символов, иначе false.
     */
    public boolean compareStructureWords(String s1, String s2) {
        return this.getMapFromString(s1).equals(this.getMapFromString(s2));
    }

    /**
     * Получить символы встречающиеся в слове несколько раз.
     *
     * @param s слово.
     * @return дубликаты слова.
     */
    public List<Character> duplicatedSymbols(String s) {
        Map<Character, Integer> map = this.getMapFromString(s);
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Проверить что два слова отличаются на одну перестановку символов.
     *
     * @param s1 первое слово.
     * @param s2 второе слова.
     * @return true, если отличаются на одну перестановку, иначе false.
     */
    public boolean differByOnePermutation(String s1, String s2) {
        List<Character> differSymbols = new ArrayList<>();
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (!(s1.charAt(i) == s2.charAt(i))) {
                    differSymbols.add(s1.charAt(i));
                    differSymbols.add(s2.charAt(i));
                }
            }
        }
        return differSymbols.size() == 4
                && differSymbols.get(0).equals(differSymbols.get(3))
                && differSymbols.get(1).equals(differSymbols.get(2));
    }

    /**
     * Получить коллекцию уникальных символов из слова.
     *
     * @param s слово.
     * @return коллекция уникальных символов.
     */
    public Map<Character, Integer> getMapFromString(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (!result.containsKey(symbol)) {
                result.put(symbol, 1);
            } else {
                result.put(symbol, result.get(symbol) + 1);
            }
        }
        return result;
    }
}
