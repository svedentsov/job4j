package ru.job4j.vacancy.jsoup;

import ru.job4j.vacancy.Vacancy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represents basic interface of jsoup parser.
 */
public interface JsoupProcessor {
    /**
     * Parses vacancies from site to list
     *
     * @param dateLimit date limiter
     * @return parsed vacancies
     */
    List<Vacancy> parseVacancies(LocalDateTime dateLimit);

    /**
     * Sets vacancy filter as string predicate
     *
     * @param filter vacancy filter
     */
    void submitSearchFilter(Predicate<String> filter);

    /**
     * Appends in link line the given word
     *
     * @param word word
     */
    void submitSearchWord(String word);
}