package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Класс тестирует зацикленность элементов связанного списка.
 */
public class NodeTest {
    Node<Integer> first = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> four = new Node<>(4);

    /**
     * Тест проверяет незацикленный список на наличие зацикленностей.
     */
    @Test
    public void whenHasNoCycleShouldFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        assertFalse(first.hasCycle(first));
    }

    /**
     * Тест проверяет зацикленный список на наличие зацикленностей.
     * Список зациклен с последнего элемента на первый.
     */
    @Test
    public void whenHasCycleFromLastToFirstShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }

    /**
     * Тест проверяет зацикленный список на наличие зацикленностей.
     * Список зациклен с третьего элемента на второй.
     */
    @Test
    public void whenHasCycleFromThirdToTwoShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }
}