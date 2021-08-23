package ru.job4j.io.searcher;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Реализация вывода содержимого всей директории, включая вложенные файлы.
 * Используется встроенный механизм Java - интерфейс FileVisitor.
 * В интерфейсе FileVisitor использован только метод только visitFile.
 * Java последовательно передает в visitFile файлы, которые обрабатываются.
 */
public class SearchFiles extends SimpleFileVisitor<Path> {

    private final List<Path> paths;
    private final Predicate<Path> condition;

    public SearchFiles(Predicate<Path> condition) {
        this.paths = new ArrayList<>();
        this.condition = condition;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            paths.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return paths;
    }
}
