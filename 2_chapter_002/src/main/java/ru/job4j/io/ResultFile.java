package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Класс реализует запись данных в файл.
 */
public class ResultFile {

    public static void main(String[] args) {
        int[][] matrix = new Matrix().multiple(4);
        try (FileOutputStream fos = new FileOutputStream(
                "./2_chapter_002/src/main/resources/result.txt")) {
            for (int[] ints : matrix) {
                String strInts = Arrays.toString(ints);
                fos.write((strInts + System.lineSeparator()).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
