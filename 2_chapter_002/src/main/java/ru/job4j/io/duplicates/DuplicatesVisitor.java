package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

/**
 * 4.2. Поиск дубликатов
 * Нужно написать программу, которая принимает на вход папку,
 * просматривает все файлы в ней и сообщает, если находит дубликаты.
 * Дубликаты – это два файла с одинаковым именем и размером.
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Set<FileProperty> propertyAll = new HashSet<>();

    /**
     * Метод вызывается каждый раз, когда встречается файл.
     * Используем этот метод, чтобы проверить файл на наличие дубля.
     *
     * @param file  проверяемый файл
     * @param attrs атрибуты проверяемого файла
     * @return CONTINUE
     * @throws IOException возможно возникновение IO исключений
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(
                file.toFile().length(),
                file.getFileName().toString());
        if (propertyAll.contains(fileProperty)) {
            System.out.println(file.toAbsolutePath());
        } else {
            propertyAll.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}
