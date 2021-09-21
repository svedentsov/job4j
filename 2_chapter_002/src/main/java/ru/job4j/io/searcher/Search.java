package ru.job4j.io.searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс осуществляет поиск файлов с определенным расширением в директории и поддиректориях.
 * Программа должна запускаться с параметрами.
 * Первый параметр - начальная папка.
 * Второй параметр - расширение файлов, которые нужно искать. Необходимо добавить валидацию данных параметров.
 */
public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        if (args.length < 2) {
            throw new IllegalArgumentException("There is no file extension.");
        }
        Path start = Paths.get(args[0]);
        search(start, p -> p
                .toFile()
                .getName()
                .endsWith(args[1])).forEach(System.out::println);
    }

    /**
     * Поиск файлов с заданным расширением.
     *
     * @param root      корневая директория
     * @param condition предикат поиска файлов
     * @return список найденных файлов
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
