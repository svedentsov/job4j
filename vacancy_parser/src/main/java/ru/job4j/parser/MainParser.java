package ru.job4j.parser;

import org.jsoup.helper.Validate;

/**
 * Запуск приложения.
 */
public class MainParser {

    public static void main(String[] args) {
        Validate.isTrue(args.length < 1, "fill properties");
        ParserJob pj = new ParserJob();
        pj.run();
    }
}
