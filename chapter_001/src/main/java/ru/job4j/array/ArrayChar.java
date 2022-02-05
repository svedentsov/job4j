package ru.job4j.array;

/**
 * Класс реализует проверку, что слово начинается с префикса.
 */
public class ArrayChar {
    /**
     * Проверить, что слово начинается с префикса.
     *
     * @param word   строка содержащая слово.
     * @param prefix строка содержащая часть слова.
     * @return true если слово начинается с префикса, иначе false.
     */
    public boolean startWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] != wrd[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
