package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс реализует чтение/запись данных файла через буферизированные потоки
 */
public class LogFilter {

    private final static String ERROR_CODE = "404";

    /**
     * Прочитать файл и вернуть строки, где предпоследнее число - 404.
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            result = in.lines()
                    .filter(s -> s.contains(ERROR_CODE))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Сохранить результаты в файл.
     *
     * @param log  оригинальный файл с логами
     * @param file файл для сохранения результатов
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            log.stream().map(str -> str + System.lineSeparator()).forEach(out::write);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("./chapter_006/src/main/resources/log.txt");
        save(log, "./chapter_006/src/main/resources/404.txt");
        System.out.println("Результат фильтрации строк из файла log.txt");
        log.forEach(System.out::println);
    }
}
