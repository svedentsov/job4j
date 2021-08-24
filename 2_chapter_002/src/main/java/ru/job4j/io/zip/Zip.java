package ru.job4j.io.zip;

import ru.job4j.io.ArgsName;
import ru.job4j.io.searcher.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс архивации папки в zip-архив.
 */
public class Zip {

    /**
     * Архивировать файлы в zip-архив.
     *
     * @param sources список путей к файлам
     * @param target  имя и расширение архивного файла
     */
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zipOutputStream.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source.toString()))) {
                    //System.out.println("zipping " + source);
                    zipOutputStream.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для упаковки в архив одного файла.
     *
     * @param source файл для архивации
     * @param target zip-файл
     */
    public static void packSingleFile(Path source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.toString()));
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source.toString()))) {
                zip.write(in.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException(
                    "Folder to archive, file exclusion, or archive name is null. "
                            + "Usage java -jar pack.jar -d=ROOT_FOLDER -e=EXCLUSION_EXTENSION -o=SOURCE_ARCHIVE_NAME.");
        }
        ArgsName arguments = ArgsName.of(args);
        Path root = Path.of(arguments.get("d"));
        if (!Files.exists(root)) {
            throw new IllegalArgumentException(
                    "Specified root folder does not exist. Please, specify an existing folder");
        }
        String extension = arguments.get("e");
        File target = new File(arguments.get("o"));
        List<Path> sources = Search.search(root, path -> !path.toFile().getName().endsWith(extension));
        packFiles(sources, target);
    }
}
