package ru.job4j.vacancy;

import ru.job4j.vacancy.jsoup.HhRuJsoupProcessor;
import ru.job4j.vacancy.jsoup.JsoupProcessor;
import ru.job4j.vacancy.util.JsoupHelper.Filters;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * For manual testing
 */
public class ManualTest {
    public static void main(String[] args) {
        //System.out.println(getVacancies(new SqlRuJsoupProcessor()).size());
        System.out.println(getVacancies(new HhRuJsoupProcessor()).size());
        //System.out.println(getVacancies(new MoiKrugJsoupProcessor()).size());
    }

    private static List<Vacancy> getVacancies(JsoupProcessor processor) {
        processor.submitSearchFilter(Filters::javaFilter);
        processor.submitSearchWord("java");
        LocalDateTime dateLimit = LocalDateTime.now().with(LocalTime.MIN).minusYears(20);
        return processor.parseVacancies(dateLimit);
    }
}
