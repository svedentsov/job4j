package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса Tracker.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Добавления новой заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Замены существующей заявки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Успешное удаление заявки.
     */
    @Test
    public void whenDeleteItemSuccess() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        Item previous1 = new Item("test2");
        tracker.add(previous);
        tracker.add(previous1);
        tracker.delete(previous1.getId());
        List<Item> resul=tracker.findAll();
        List<Item> n=new ArrayList<Item>();
        n.add(previous);
        assertArrayEquals(resul.toArray(),n.toArray());
    }

    /**
     * Проверка неуспешного удаления заявки.
     */
    @Test
    public void whenDeleteItemThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        tracker.add(first);
        boolean result = tracker.delete("test2");
        assertThat(result, is(false));
    }

    /**
     * Проверка в цикле все элементов массива по названию.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        Item previous1 = new Item("test2");
        tracker.add(previous);
        tracker.add(previous1);
        List<Item> resul=tracker.findByName("test2");
        List<Item> n=new ArrayList<Item>();
        n.add(previous1);
        assertArrayEquals(resul.toArray(),n.toArray());
    }
}
