package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    /**
     * Проверка добавления новой заявки.
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
     * Проверка замены существующей заявки.
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
     * Проверка успешного удаления заявки.
     */
    @Test
    public void whenDeleteItemThenReturnTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        tracker.add(first);
        boolean result = tracker.delete(first.getName());
        assertThat(result, is(true));
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
        Item first = new Item("test1");
        Item second = new Item("test2");
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findByName("test1"), is(new Item[]{first}));
    }

    /**
     * Проверка поиска всех элементов массива.
     */
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        tracker.add(first);
        tracker.add(second);
        Item[] result = tracker.findAll();
        Item[] expected = {second, first};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}
