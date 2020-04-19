package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс School.
 */
public class School {
    /**
     * Получить список учеников по выбранному условию.
     *
     * @param students ученики
     * @param predict  условие
     * @return список учеников
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     * Получить Map из List.
     *
     * @param students список студентов.
     * @return карта студентов.
     */
    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(Student::getSurname, o -> o)
        );
    }
}
