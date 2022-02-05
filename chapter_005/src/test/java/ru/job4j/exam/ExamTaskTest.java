package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExamTaskTest {

    ExamTask task = new ExamTask();

    @Test
    public void whenCompareStructureTwoWordsThenResult() {
        assertThat(task.compareStructureWords("тест", "ячсм"), is(false));
        assertThat(task.compareStructureWords("zxc", "cxz"), is(true));
    }

    @Test
    public void whenDifferByOnePermutationThenResult() {
        assertThat(task.differByOnePermutation("тестирование", "етстирование"), is(true));
        assertThat(task.differByOnePermutation("тестирование", "ттиесрование"), is(false));
    }

    @Test
    public void whenFindDuplicatedSymbolsThenResult() {
        assertThat(task.duplicatedSymbols("тестирование").size(), is(3));
        assertThat(task.duplicatedSymbols("тест").size(), is(1));
    }
}
