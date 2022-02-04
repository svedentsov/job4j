package ru.job4j.vacancy.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.vacancy.Vacancy;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.LocalDate.now;
import static org.mockito.BDDMockito.given;
import static ru.job4j.vacancy.util.JsoupHelper.buildDocument;

public class SqlRuJsoupProcessorTest extends AbstractJsoupProcessorTest {
    private static final Vacancy EXPECTED_VACANCY_SQL_RU = new Vacancy(
            "Требуется программист (Москва, Сбербанк)", "sql.ru/topic.mock.url", "test description\ntest details",
            LocalDateTime.of(2019, 8, 12, 21, 17));

    private static final Document EMPTY_MOCK_PAGE_SQL_RU = Jsoup.parse(
            "<table class=\"forumTable\">"
                    + "    <tr><th>Header</th></tr>"
                    + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Сообщения от модераторов</a></td></tr>"
                    + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Шпаргалки</a></td></tr>"
                    + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Правила форума</a></td></tr>"
                    + "</table>");

    private static final Document MOCK_PAGE_SQL_RU = Jsoup.parse("<table class=\"forumTable\">"
            + "<tr>"
            + "     <td class=\"postslisttopic\"><a href=\"sql.ru/topic.mock.url\">Требуется программист (Москва, Сбербанк)</a></td>"
            + "     <td class=\"altCol\"></td>"
            + "     <td>56</td>"
            + "     <td>1514</td>"
            + "     <td class=\"altCol\">12 авг 19, 21:17</td>"
            + "</tr>"
            + "<tr>"
            + "     <td class=\"postslisttopic\"><a href=\"sql.ru/topic.mock.url\">Требуется уборщица (Москва, Сбербанк)</a></td>"
            + "     <td class=\"altCol\"></td>"
            + "     <td>56</td>"
            + "     <td>1514</td>"
            + "     <td class=\"altCol\">20 июл 19, 10:10</td>"
            + "</tr>"
            + "</table>");

    private static final Document MOCK_TOPIC_PAGE_SQL_RU = Jsoup.parse("<html>"
            + "<head><title>Test Topic</title></head>"
            + "<body>"
            + "<table class=\"msgTable\">"
            + "    <tr><td id=\"id121211\" class=\"messageHeader\">Java developer</td></tr>"
            + "    <tr>"
            + "        <td class=\"msgBody\"><a href=\"\">First message<br /></a></td>"
            + "        <td class=\"msgBody\">"
            + "            test description<br />"
            + "            test details"
            + "        </td>"
            + "    </tr>"
            + "    <tr>"
            + "        <td class=\"msgBody\"><a href=\"\">Second message<br /></a></td>"
            + "        <td class=\"msgBody\">"
            + "            next description<br />"
            + "            next details"
            + "        </td>"
            + "    </tr>"
            + "</table>"
            + "</body>"
            + "</html>");

    public SqlRuJsoupProcessorTest() {
        super(new SqlRuJsoupProcessor(), EXPECTED_VACANCY_SQL_RU);
    }

    @Before
    @Override
    public void setUp() throws IOException {
        super.setUp();
        given(buildDocument("sql.ru/topic.mock.url"))
                .willReturn(MOCK_TOPIC_PAGE_SQL_RU); // on sql.ru vac's description would be grabbed from the (another) topic page — had to mock it
    }

    @Override
    Element mockRow() {
        return MOCK_PAGE_SQL_RU.getElementsByTag("tr").first();
    }

    @Override
    void mockDocument() throws IOException {
        given(buildDocument("https://www.sql.ru/forum/job-offers/1"))
                .willReturn(MOCK_PAGE_SQL_RU);
    }

    @Override
    void mockEmptyDocument() throws IOException {
        given(buildDocument("https://www.sql.ru/forum/job-offers/1"))
                .willReturn(EMPTY_MOCK_PAGE_SQL_RU);
    }

    @Test
    public void getAllVacancyRowsOnPage() {
        Document rows = Jsoup.parse(
                "<table class=\"forumTable\">"
                        + "    <tr><th>Header</th></tr>"
                        + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Сообщения от модераторов</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Шпаргалки</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\">Важно: <a href=\"\">Правила форума</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\"><a href=\"\">Требуется программист</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\"><a href=\"\">Требуется массажист</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\"><a href=\"\">Требуется ветеринар</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\"><a href=\"\">Требуется муж</a></td></tr>"
                        + "    <tr><td class=\"postslisttopic\"><a href=\"\">Требуется внимание</a></td></tr>"
                        + "</table>"
        );
        tester.getAllVacancyRowsOnPage(5, rows);
    }

    @Test
    public void mainLoopCountCircles() throws IOException {
        tester.mainLoopCountCircles(1000, i -> i < 1000); // nothing could stop the main loop iterations
    }

    @Test
    public void buildPageLink() {
        var expected = "https://www.sql.ru/forum/job-offers/10";
        tester.buildPageLink(expected, null, 10);
    }

    @Test
    public void buildPageLinkSearchWordWasIgnored() {
        var expected = "https://www.sql.ru/forum/job-offers/100";
        tester.buildPageLink(expected, "searchtest", 100);
    }

    @Test
    public void composeTitle() {
        var row = Jsoup.parse("<table>"
                + "<tr>"
                + "     <td class=\"postslisttopic\"><a href=\"\">Требуется программист</a></td>"
                + "     <td class=\"altCol\"></td>"
                + "     <td>56</td>"
                + "     <td>1514</td>"
                + "     <td class=\"altCol\">сегодня, 10:29</td>"
                + "</tr>"
                + "</table>");
        tester.composeTitle("Требуется программист", row);
    }

    @Test
    public void grabDateTime() {
        var row = Jsoup.parse("<table>"
                + "<tr>"
                + "     <td class=\"postslisttopic\"><a href=\"\">Требуется программист</a></td>"
                + "     <td class=\"altCol\"></td>"
                + "     <td>56</td>"
                + "     <td>1514</td>"
                + "     <td class=\"altCol\">test_date</td>"
                + "</tr>"
                + "</table>");
        tester.grabDateTime(row);
    }

    @Test
    public void parseDateTime() {
        tester.parseDateTime(LocalDate.of(2019, 8, 12), LocalTime.of(14, 11),
                "12 авг 19, 14:11");
    }

    @Test
    public void parseDateTimeToday() {
        tester.parseDateTime(now(), LocalTime.of(8, 11),
                "сегодня, 08:11");
    }

    @Test
    public void parseDateTimeYesterday() {
        tester.parseDateTime(now().minusDays(1), LocalTime.of(23, 59),
                "вчера, 23:59");
    }

    @Test
    public void grabLink() {
        var row = Jsoup.parse("<table>"
                + "<tr>"
                + "     <td class=\"postslisttopic\"><a href=\"http://mock.url\">Требуется программист</a></td>"
                + "     <td class=\"altCol\"></td>"
                + "     <td>56</td>"
                + "     <td>1514</td>"
                + "     <td class=\"altCol\">test_date</td>"
                + "</tr>"
                + "</table>");
        tester.grabLink("http://mock.url", row);
    }

    @Test
    public void grabDescription() throws IOException {
        var row = Jsoup.parse("<table>"
                + "<tr>"
                + "     <td class=\"postslisttopic\"><a href=\"sql.ru/topic.mock.url\">Требуется программист</a></td>"
                + "     <td class=\"altCol\"></td>"
                + "     <td>56</td>"
                + "     <td>1514</td>"
                + "     <td class=\"altCol\">test_date</td>"
                + "</tr>"
                + "</table>");
        tester.grabDescription("test description\ntest details", row);
    }
}
