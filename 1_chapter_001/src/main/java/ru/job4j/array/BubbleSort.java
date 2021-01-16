package ru.job4j.array;

/**
 * Сортировка массива пузырьком.
 */
public class BubbleSort {
    /**
     * Метод сортирует массив по возрастанию используя метод перестановок ("пузырьковая сортировка")
     * tmp - временная переменная для перестановок
     * цикл i уменьшается справа по мере выталкивания максимальных элементов
     * цикл j пробегает внутри i и проверяет условие
     * Если первый элемент больше второго, то они меняются местами
     * Таким образом, в конец цикла j выталкивается самый большой элемент, который отсекается циклом i.
     *
     * @param array массив int
     * @return отортированный массив
     */

    public int[] sort(int[] array) {
        int tmp;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
