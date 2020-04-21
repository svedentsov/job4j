package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка класса School.
 */
public class SchoolTest {
    private School school = new School();
    private List<Student> students = List.of(
            new Student("Студент 1", 10),
            new Student("Студент 2", 12),
            new Student("Студент 3", 50),
            new Student("Студент 4", 30),
            new Student("Студент 5", 60),
            new Student("Студент 6", 100)
    );

    @Test
    public void classA70to100() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 70 && student.getScore() <= 100
        ).collect(Collectors.toList());
        assertThat(result.size(), is(1));
    }

    @Test
    public void classB50to70() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 50 && student.getScore() <= 70
        ).collect(Collectors.toList());
        assertThat(result.size(), is(1));
    }

    @Test
    public void classC0to50() {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > 0 && student.getScore() <= 50
        ).collect(Collectors.toList());
        assertThat(result.size(), is(4));
    }

    @Test
    public void convertListToMap() {
        Map<String, Student> result = school.convertListToMap(students);
        assertThat(result.get("Студент 3").getScore(), is(50));
    }

    @Test
    public void listStudentsScore() {
        List<Student> expected = List.of(
                new Student("Студент 6", 100),
                new Student("Студент 5", 60)
        );
        List<Student> actual = new School().levelOf(students, 50);
        assertThat(actual, is(expected));
    }
}
