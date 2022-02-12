package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для работы со списком учеников.
 */
public class School {
    /**
     * Фильтрация учеников в зависимости от заданного диапазона баллов.
     *
     * @param students список учеников.
     * @param predict  условие фильтрации учеников.
     * @return отфильтрованный список учеников.
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * Преобразование списка учеников из List в Map.
     *
     * @param students список учеников.
     * @return Map учеников (ключ: фамилия ученика; значение: объект ученика).
     */
    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, o -> o));
    }

    /**
     * Фильтрация учеников по количеству баллов больше bound.
     *
     * @param students список учеников.
     * @param bound    количество баллов.
     * @return List учеников с количеством баллов больше bound.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(o -> o.getScore() > bound)
                .collect(Collectors.toList());
    }
}
