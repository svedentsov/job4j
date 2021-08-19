package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс осуществляет поиск файлов с определенным расширением в директории и поддиректориях.
 */
public class Search {

    /**
     * Поиск файлов с заданным расширением.
     *
     * @param root      корневой каталог поиска
     * @param condition расширение файла, которое нужно искать
     * @return список имен файлов
     */
    public List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
