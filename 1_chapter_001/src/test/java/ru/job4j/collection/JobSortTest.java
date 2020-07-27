package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Проверка сортировки объектов класса Job.
 */
public class JobSortTest {
    /**
     * Проверка сортировки по полю имя (по возрастанию)
     */
    @Test
    public void whenSortByNameAsc() {
        Comparator<Job> cmpName = new JobSortByNameAsc();
        int rsl = cmpName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    /**
     * Проверка сортировки по полю имя (по убыванию)
     */
    @Test
    public void whenSortByNameDesc() {
        Comparator<Job> cmpName = new JobSortByNameDesc();
        int rsl = cmpName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * Проверка сортировки по полю приотет (по возрастанию)
     */
    @Test
    public void whenSortByPriorityAsc() {
        Comparator<Job> cmpPriority = new JobSortByPriorityAsc();
        int rsl = cmpPriority.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, is(greaterThan(0)));
    }

    /**
     * Проверка сортировки по полю приотет (по убыванию)
     */
    @Test
    public void whenSortByPriorityDesc() {
        Comparator<Job> cmpPriority = new JobSortByPriorityDesc();
        int rsl = cmpPriority.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, is(lessThan(0)));
    }

    /**
     * Проверка совместной сортировки по полям имя и приотет (по возрастанию)
     */
    @Test
    public void whenSortByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobSortByNameAsc().thenComparing(new JobSortByPriorityAsc());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * Проверка совместной сортировки по полям имя и приотет (по убыванию)
     */
    @Test
    public void whenSortByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobSortByNameAsc().thenComparing(new JobSortByPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        System.out.println(rsl);
        assertThat(rsl, greaterThan(0));
    }
}
