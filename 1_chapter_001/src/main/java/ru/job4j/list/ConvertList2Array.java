package ru.job4j.list;

import java.util.List;

/**
 * Преобразования списка в двухмерный массив.
 */
public class ConvertList2Array {
    /**
     * Преобразование списка в массив.
     *
     * @param list  список
     * @param cells ячеек в строке
     * @return массив
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell] = num;
            cell++;
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }
}