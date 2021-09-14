package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс демонстрирует работу с шаблоном для подстановки переменных реализованном в библиотеке логирования slf4j
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int a = 0;
        byte b = 1;
        short c = 4;
        float d = 2.0f;
        double e = 3.0d;
        long f = 5L;
        boolean g = true;
        char h = 'a';
        LOG.debug("8 variables : int a : {}, byte b : {}, short c : {}, float d : {}, double e : {}, long f : {}, boolean g : {}, char h : {}",
                a, b, c, d, e, f, g, h);
    }
}
