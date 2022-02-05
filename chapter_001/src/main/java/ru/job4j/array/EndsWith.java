package ru.job4j.array;

/**
 * Класс реализует проверку, что слово заканчивается постфиксом.
 */
public class EndsWith {
    /**
     * Проверить, что слово заканчивается постфиксом.
     *
     * @param word слово
     * @param post постфикс
     * @return true - слово заканчивается постфиксом, иначе false
     */
    public boolean endsWith(String word, String post) {
        char[] wrd = word.toCharArray();
        char[] pst = post.toCharArray();
        for (int i = 0; i < pst.length; i++) {
            if (wrd[wrd.length - i - 1] != pst[pst.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
