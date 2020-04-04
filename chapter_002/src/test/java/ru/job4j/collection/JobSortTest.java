package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Тестирование сортировки объектов класса Job.
 */
public class JobSortTest {
    @Test
    public void whenSortByNameAsc() {
        Comparator<Job> cmpName = new JobSortByNameAsc();
        int rsl = cmpName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSortByNameDesc() {
        Comparator<Job> cmpName = new JobSortByNameDesc();
        int rsl = cmpName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortByPriorityAsc() {
        Comparator<Job> cmpPriority = new JobSortByPriorityAsc();
        int rsl = cmpPriority.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, is(greaterThan(0)));
    }

    @Test
    public void whenSortByPriorityDesc() {
        Comparator<Job> cmpPriority = new JobSortByPriorityDesc();
        int rsl = cmpPriority.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, is(lessThan(0)));
    }

    @Test
    public void whenSortByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobSortByNameDesc().thenComparing(new JobSortByPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortByNameAsc().thenComparing(new JobSortByPriorityAsc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}
