package ru.job4j.stream;

/**
 * Класс Student.
 */
public class Student {
    /**
     * Фамилия студента.
     */
    private String surname;
    /**
     * Количество баллов.
     */
    private int score;

    /**
     * Дефолтный констуктор.
     * @param surname фамилия студента.
     * @param score   количество баллов.
     */
    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    /**
     * Получить количество баллов.
     *
     * @return количсетво баллов.
     */
    public int getScore() {
        return score;
    }

    /**
     * Получить фамилию студента.
     *
     * @return фамилия студента.
     */
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }
}
