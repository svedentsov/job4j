package ru.job4j.vacancy;

import org.junit.Test;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import ru.job4j.vacancy.TestData.JobExample;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static ru.job4j.vacancy.util.Util.now;

public class JobExecutorTest {
    @Test
    public void testExecute() throws Exception {
        String data = new StringJoiner("\n")
                .add("db.driver=testDriver")
                .add("db.url=testUrl")
                .add("db.username=testUsername")
                .add("db.password=testPassword")
                .add("cron.time=0 0/1 * * * ?") // every single minute
                .toString();
        JobExecutor executor = new JobExecutor();
        try (InputStream in = new ByteArrayInputStream(data.getBytes())) {
            executor.loadProperties(in);
        }
        executor.start();
        LocalDateTime expected = now().plusMinutes(1);
        Date actual = executor.execute(JobExample.class, List.of("db.username", "db.password"), List.of());
        assertMatch(actual, expected);

        JobKey jobKey = JobKey.jobKey(JobExample.class.getSimpleName());
        JobDataMap dataMap = executor.scheduler().getJobDetail(jobKey).getJobDataMap();

        assertEquals("testUsername", dataMap.getString("db.username"));
        assertEquals("testPassword", dataMap.getString("db.password"));
        assertNull(dataMap.getString("db.driver"));
        assertNull(dataMap.getString("db.url"));
        executor.shutdown(false);
    }

    @Test
    public void testExecuteWithoutCronExpression() throws Exception {
        String data = new StringJoiner("\n")
                .add("db.driver=testDriver")
                .add("db.url=testUrl")
                .add("db.username=testUsername")
                .add("db.password=testPassword")
                .toString();
        JobExecutor executor = new JobExecutor();
        try (InputStream in = new ByteArrayInputStream(data.getBytes())) {
            executor.loadProperties(in);
        }
        executor.start();
        LocalDateTime expected = now();
        Date actual = executor.execute(JobExample.class, List.of(), List.of());
        assertMatch(actual, expected);
        executor.shutdown(false);
    }

    private void assertMatch(Date actualDate, LocalDateTime expected) {
        LocalDateTime actual = LocalDateTime.ofInstant(actualDate.toInstant(), ZoneId.systemDefault()).truncatedTo(MINUTES);
        assertEquals(expected, actual);
    }
}
