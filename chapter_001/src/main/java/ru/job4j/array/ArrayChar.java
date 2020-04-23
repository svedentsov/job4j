package ru.job4j.array;

public class ArrayChar {
    /**
     * Проверяет, что слово word начинается с префикса prefix.
     *
     * @param word   слово
     * @param prefix префиск
     * @return если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int index = 0; index < pref.length; index++) {
            if (wrd[index] != pref[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
