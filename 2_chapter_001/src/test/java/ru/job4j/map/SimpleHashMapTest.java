package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleHashMapTest {

    private User first = new User("petr", 3, new GregorianCalendar(2017, 3, 1));
    private User duplicate = new User("petr", 3, new GregorianCalendar(2017, 3, 1));
    private User second = new User("ivan", 1, new GregorianCalendar(2015, 2, 15));
    private User third = new User("artem", 2, new GregorianCalendar(2007, 6, 24));

    /**
     * Проверка добавления объекта в контейнер.
     */
    @Test
    public void whenAddOneElemThenSizeOne() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.first, 1);
        assertThat(map.size(), is(1));
    }

    /**
     * Проверка поведения при добавления дубликата в контейнер.
     */
    @Test
    public void whenAddDuplicateThenSizeOne() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.first, 1);
        map.insert(this.duplicate, 2);
        assertThat(map.size(), is(1));
    }

    /**
     * Проверка поиска элемента по значения.
     */
    @Test
    public void whenCheckToContainsElementThenTrue() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.first, 1);
        map.insert(this.second, 3);
        assertThat(map.get(this.first), is(1));
        assertThat(map.get(this.second), is(3));
        assertNull(map.get(this.third));
    }

    /**
     * Проверка удаления объекта из контейнера.
     */
    @Test
    public void whenRemoveElementThenTrue() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.first, 1);
        map.insert(this.second, 2);
        assertThat(map.delete(this.second), is(true));
        assertThat(map.size(), is(1));
    }

    /**
     * Проверка получения false, если объект для удаления отсутствует в контейнере.
     */
    @Test
    public void whenRemoveElementThatNotPresentThenFalse() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.first, 1);
        map.insert(this.second, 2);
        assertThat(map.delete(this.third), is(false));
    }

    /**
     * Проверка увеличения массив.
     */
    @Test
    public void whenAddMoreThenDefaultCapacity16ThenNextAddWillOk() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        for (int i = 1; i <= 20; i++) {
            map.insert(String.valueOf(i), i);
        }
        assertThat(map.size(), is(20));
    }
}
