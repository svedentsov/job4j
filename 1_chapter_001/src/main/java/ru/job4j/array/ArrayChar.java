package ru.job4j.array;

/**
 * Класс проверяет что слово начинается с заданного значения.
 */
public class ArrayChar {
    private char[] data;
    /**
     * Конструктор. Преобразует строку в массив символов и присваивает его массиву data.
     *
     * @param line строка содержащая полное слово
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Метод проверяет, что слово начинается с префикса.
     *
     * @param prefix строка содержащая часть слова
     * @return true если слово начинается с префикса, иначе false
     */
    public boolean startsWith(String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            if (data[i] != pref[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
