package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует прием массива параметров и разбивает их на пары.
 */
public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    /**
     * Фабричный метод.
     *
     * @param args массив параметров в формате ключ:значение
     * @return объект типа ArgsName с обработанными параметрами
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * Разбить массив параметров на пары ключ:значение.
     *
     * @param args массив параметров в формате ключ:значение
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Parameters do not exist");
        }
        for (String s : args) {
            String[] split = s.replaceFirst("-", "").split("=");
            if (split.length != 2) {
                throw new IllegalArgumentException("Parameter value missing");
            }
            values.put(split[0], split[1]);
        }
    }

    /**
     * Получить значение ключа.
     *
     * @param key ключ
     * @return значение
     */
    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("No such parameter exists");
        }
        return values.get(key);
    }
}
