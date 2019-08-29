package ru.job4j.array;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EndsWith {
    /**
     * Проверяет, что слово word заканчивается постфиксом post
     *
     * @param word слово
     * @param post постфикс
     * @return если слово заканчивается постфиксом
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
