package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFiles extends SimpleFileVisitor<Path> {
    /**
     * Результат поиска.
     */
    private final List<Path> result = new ArrayList<>();
    /**
     * Предикат типа файла.
     */
    private final Predicate<Path> predicate;

    /**
     * Конструктор создания объекта.
     *
     * @param predicate предикат
     */
    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    /**
     * Метод возвращает результат.
     *
     * @return результат поиска
     */
    public List<Path> getPaths() {
        return result;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (this.predicate.test(file)) {
            result.add(file);
        }
        return CONTINUE;
    }
}
