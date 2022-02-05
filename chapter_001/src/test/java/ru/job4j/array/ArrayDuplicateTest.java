package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

/**
 * Проверка класса ArrayDuplicate.
 * Метод arrayContainingInAnyOrder() проверяется отсутствие дубликатов в массиве, но не их порядок.
 */
public class ArrayDuplicateTest {
    /**
     * Проверка удаления дубликатов из массива строк.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Проверка удаления дубликатов из массива строк, если уникально только одно слово.
     */
    @Test
    public void removeDuplicatesThenInArrayFiveDuplicateWords() {
        String[] input = {"Тест", "Тест", "Тест", "Тест", "Тест"};
        String[] expect = {"Тест"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Удаление из массива дубликатов строк отсутствует, все слова уникальные.
     */
    @Test
    public void removeDuplicatesThenAllWordsUnique() {
        String[] input = {"Привет", "Мир", "Здравствуй", "Java"};
        String[] expect = {"Мир", "Привет", "Java", "Здравствуй"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
