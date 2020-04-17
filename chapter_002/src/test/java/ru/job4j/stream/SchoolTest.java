package ru.job4j.stream;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

/**
 * Проверка класса School.
 */
public class SchoolTest {
    List<Student> students = List.of(
            new Student(10),
            new Student(12),
            new Student(50),
            new Student(30),
            new Student(60),
            new Student(100)
    );

    @Test
    public void classA70to100() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 70 && student.getScore() <= 100
        ).collect(Collectors.toList());
        assertThat(result.size(), Is.is(1));
    }

    @Test
    public void classB50to70() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 50 && student.getScore() <= 70
        ).collect(Collectors.toList());
        assertThat(result.size(), Is.is(1));
    }

    @Test
    public void classC0to50() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 0 && student.getScore() <= 50
        ).collect(Collectors.toList());
        assertThat(result.size(), Is.is(4));
    }
}
