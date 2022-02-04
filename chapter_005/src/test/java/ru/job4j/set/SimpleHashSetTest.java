package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashSetTest {

    private SimpleHashSet<Object> set;

    @Before
    public void beforeTest() {
        set = new SimpleHashSet<>();
    }

    /**
     * Проверяем что объект добавляется в контейнер.
     */
    @Test
    public void whenAddOneElemThenSizeOne() {
        set.add("1");
        assertThat(set.size(), is(1));
    }

    /**
     * Проверяем что дубликаты не добавляется в контейнер.
     */
    @Test
    public void whenAddDuplicateThenSizeOne() {
        set.add(1);
        set.add(1);
        assertThat(set.size(), is(1));
    }

    /**
     * Проверяем что поиск элемента по значение отрабатывает корректно.
     */
    @Test
    public void whenCheckToContainsElementThenTrue() {
        set.add(1);
        set.add(2);
        assertThat(set.contains(2), is(true));
    }

    /**
     * Проверяем что удаление объекта из контейнера проходит корректно.
     */
    @Test
    public void whenRemoveElementThenTrue() {
        set.add(1);
        set.add(2);
        assertThat(set.remove(2), is(true));
    }

    /**
     * Првоеряем, что если такого объекта для удаления нет в
     * контейнере, то вернется false.
     */
    @Test
    public void whenRemoveElementThatNotPresentThenFalse() {
        set.add(1);
        set.add(2);
        assertThat(set.remove(5), is(false));
    }

    /**
     * Проверяем что массив увеличивается.
     */
    @Test
    public void whenAddMoreThenDefaultCapacity16ThenNextAddWillOk() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        IntStream.rangeClosed(1, 20).forEach(set::add);
        assertThat(set.size(), is(20));
    }

    /**
     * Проверяем что при добавлении null выбрасывается ошибка NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void whenAddNullThenException() {
        set.add(null);
    }
}
