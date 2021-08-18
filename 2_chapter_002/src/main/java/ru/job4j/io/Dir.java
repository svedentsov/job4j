package ru.job4j.io;

import java.io.File;

/**
 * Класс выводит имя файла в директории и его размер.
 */
public class Dir {

    public static void main(String[] args) {
        File file = new File(".");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s",
                    file.getAbsoluteFile()));
        }
        for (File subfile : file.listFiles()) {
            System.out.println("FileName : " + subfile.getName()
                    + ",  FileSize : " + subfile.length() / 1024 + "kB");
        }
    }
}
