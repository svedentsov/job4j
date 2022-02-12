package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Фильтрация вложений.
 */
public class SearchAtt {
    /**
     * Фильтр по названию.
     */
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    /**
     * Фильтр по имени.
     */
    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    /**
     * Универсальный фильтр.
     */
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment item : list) {
            if (predicate.test(item)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    /**
     * Запуск программы.
     */
    public static void main(String[] args) {
        List<Attachment> list = new ArrayList<>();
        list.add(new Attachment("picture 1", 110));
        list.add(new Attachment("bug", 200));
        list.add(new Attachment("picture 3", 320));
        System.out.println(filter(list, x -> x.getSize() > 100 && x.getName().equals("bug")));
    }
}
