package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {

    private final char[] data;

    /**
     * Преобразовать строку в массив символов и присваивает его массиву data.
     *
     * @param line строка содержащая полное слово
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверка, что слово начинается с префикса.
     *
     * @param prefix строка содержащая часть слова
     * @return true - слово начинается с префикса, иначе false
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
