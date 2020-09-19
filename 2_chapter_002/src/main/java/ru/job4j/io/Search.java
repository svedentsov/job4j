package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Класс осуществляет поиск файлов, содержащих выбранное расширение.
 */
public class Search {
    /**
     * Метод реализует поиск файлов с заданным расширением.
     *
     * @param root корневой каталог
     * @param ext  расширение файла
     * @return список имен файлов
     * @throws IOException
     */
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searchFiles = new SearchFiles((p -> p.toFile().getName().endsWith(ext)));
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }
}
