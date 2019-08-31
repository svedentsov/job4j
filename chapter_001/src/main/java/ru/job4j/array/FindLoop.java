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

    /**
     * Поиск в массиве data элемента el между индексами start и finish и возврат индекса найденного числа.
     *
     * @param data   массив для поиска
     * @param el     число для поиска
     * @param start  индекс с которого начинается поиск
     * @param finish индекс которым заканчивается поиск
     * @return индекс найденного числа в массиве (-1 если число в массиве не найдено)
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Сортирока массива выборкой.
     *
     * @param data массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minValue = data[i];
            for (int j = i + 1; j < data.length; j++) {
                minValue = data[j] < minValue ? data[j] : minValue;
            }
            int minIndex = indexOf(data, minValue, i, data.length - 1);
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }
}
