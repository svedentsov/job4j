package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Проверка расчета сдачи в кофе-машине.
 */
public class MachineTest {

    /**
     * Сдачи нет, если цена равна внесенной сумме.
     */
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    /**
     * Сдачи нет, если цена больше внесенной суммы.
     */
    @Test
    public void whenPriceMore() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(50, 100);
        assertThat(rsl, is(expected));
    }

    /**
     * Сдача 15.
     */
    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    /**
     * Сдача 18.
     */
    @Test
    public void when50by32() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 1};
        int[] rsl = machine.change(50, 32);
        assertThat(rsl, is(expected));
    }
}
