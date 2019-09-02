package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Удаление из массива дубликатов строк.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Удаление из массива дубликатов строк, если уникально только одно слово.
     */
    @Test
    public void removeDuplicatesThenInArrayFiveDuplicateWords() {
        String[] input = {"Тест", "Тест", "Тест", "Тест", "Тест"};
        String[] expect = {"Тест"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Удаление из массива дубликатов строк отсутствует, все слова уникальные.
     */
    @Test
    public void removeDuplicatesThenAllWordsUnique() {
        String[] input = {"Привет", "Мир", "Здравствуй", "Java"};
        String[] expect = {"Мир", "Привет", "Java", "Здравствуй"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
