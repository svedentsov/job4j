package ru.job4j.array;

/**
 * Поиск элемента в массиве.
 */
public class FindLoop {
    /**
     * Поиск в массиве индекса элемента.
     *
     * @param data    массив для поиска.
     * @param element число для поиска.
     * @return индекс найденного числа. Если элемента не найден, возвращаем -1.
     */
    public int indexOf(int[] data, int element) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Поиск в массиве индекса элемента между индексами.
     *
     * @param data    массив для поиска.
     * @param element число для поиска.
     * @param start   индекс с которого начинается поиск.
     * @param finish  индекс которым заканчивается поиск.
     * @return индекс найденного числа. Если элемента не найден, возвращаем -1.
     */
    public int indexOf(int[] data, int element, int start, int finish) {
        int result = -1;
        for (int i = start; i <= finish; i++) {
            if (data[i] == element) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Сортировка массива выборкой.
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
