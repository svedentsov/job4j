package ru.job4j.array;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Метод ищет в массиве data число el и возврата индекс найденного числа.
     *
     * @param data массив для поиска
     * @param el   число для поиска
     * @return индекс найденного числа в массиве (-1 если число в массиве не найдено)
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
