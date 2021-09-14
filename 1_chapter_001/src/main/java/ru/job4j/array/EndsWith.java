package ru.job4j.array;

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
        for (int index = 0; index < pst.length; index++) {
            if (wrd[wrd.length - index - 1] != pst[pst.length - index - 1]) {
                return false;
            }
        }
        return true;
    }
}
