package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void whenSingletonIsEnum() {
        TrackerEnum first = TrackerEnum.INSTANCE;
        TrackerEnum second = TrackerEnum.INSTANCE;
        assertThat(first, is(second));
    }

    @Test
    public void whenSingletonIsStaticField() {
        Tracker first = TrackerStaticField.getInstance();
        Tracker second = TrackerStaticField.getInstance();
        assertThat(first, is(second));
    }

    @Test
    public void whenSingletonIsStaticFinalField() {
        Tracker first = TrackerStaticFinalField.getInstance();
        Tracker second = TrackerStaticFinalField.getInstance();
        assertThat(first, is(second));
    }

    @Test
    public void whenSingletonIsPrivateStaticFinalClass() {
        Tracker first = TrackerPrivateStaticFinalClass.getInstance();
        Tracker second = TrackerPrivateStaticFinalClass.getInstance();
        assertThat(first, is(second));
    }
}
