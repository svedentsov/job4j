package ru.job4j.vacancy.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * Represents program strategy of moikrug.ru parsing.
 */
public class MoiKrugJsoupProcessor extends AbstractJsoupProcessor {
    private static final String SITE_NAME = "https://moikrug.ru";
    private static final String URL_TEMPLATE = "https://moikrug.ru/vacancies?q=%s&page=%d&sort=date";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy")
            .localizedBy(Locale.forLanguageTag("ru"));

    @Override
    String buildPageLink(int page) {
        return format(URL_TEMPLATE, searchWord, page);
    }

    @Override
    Elements getAllVacancyRowsOnPage(Document doc) {
        return doc.getElementsByClass("job");
    }

    @Override
    String grabTitle(Element row) {
        String title = getInnerClassText(row, "title");
        // e.g. many java-vacancies do not contain 'java' in their title on moikrug.ru
        return title.toLowerCase().contains(searchWord) ? title : setSkillIfMatched(row, title);
    }

    @Override
    String grabCity(Element row) {
        return getInnerClassText(row, "location");
    }

    @Override
    String grabCompany(Element row) {
        return getInnerClassText(row, "company_name");
    }

    @Override
    String grabDateTime(Element row) {
        return getInnerClassText(row, "date");
    }

    @Override
    LocalDateTime parseDateTime(String dateLine) {

        return LocalDateTime.of(LocalDate.parse(dateLine, FORMATTER), LocalTime.MIN);
    }

    @Override
    String grabLink(Element row) {
        return SITE_NAME + row.getElementsByClass("job_icon").first().attr("href");
    }

    @Override
    String grabDescription(Element row) throws IOException {
        return row.getElementsByClass("skill")
                .stream()
                .map(Element::text)
                .collect(Collectors.joining("\n"));
    }

    private String setSkillIfMatched(Element row, String title) {
        boolean noneMatched = row.getElementsByClass("skill")
                .stream()
                .map(Element::text)
                .noneMatch(searchWord::equalsIgnoreCase);
        return noneMatched ? title : '[' + searchWord + "] " + title;
    }

    private String getInnerClassText(Element e, String className) {
        Element first = e.getElementsByClass(className).first();
        return first != null ? first.text() : "";
    }
}
