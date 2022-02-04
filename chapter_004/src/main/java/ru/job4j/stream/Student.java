package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс Student.
 */
public class Student implements Comparable<Student> {
    /**
     * Фамилия студента.
     */
    private String surname;
    /**
     * Количество баллов.
     */
    private int score;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, score);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScore(), this.getScore());
    }
}
