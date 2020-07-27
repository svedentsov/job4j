package ru.job4j.array;

/**
 * Проверка начала строки.
 */
public class ArrayChar {
    /**
     * Проверяет, что слово начинается с префикса.
     *
     * @param word   слово
     * @param prefix префикса
     * @return если слово начинается с префикса
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
