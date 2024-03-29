package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>(
                Set.of(
                        new User("Petr", 32),
                        new User("Ivan", 31)
                )
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenSortByAge() {
        Set<User> users = new TreeSet<>(
                Set.of(
                        new User("Yuriy", 37),
                        new User("Yuriy", 31)
                )
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Yuriy", 31)));
        assertThat(it.next(), is(new User("Yuriy", 37)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32).compareTo(new User("Ivan", 31));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareTwoPert() {
        int rsl = new User("Petr", 32).compareTo(new User("Petr", 31));
        assertThat(rsl, greaterThan(0));
    }
}
