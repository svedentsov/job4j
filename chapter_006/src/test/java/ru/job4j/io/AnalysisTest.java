package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalysisTest {

    String path = "./src/main/resources/";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void before() {
        Analysis.outPrintlnFile(path + "source.log");
    }

    @Test
    public void whenUnavailable() {
        Analysis analysis = new Analysis();
        analysis.unavailable(path + "source.log", path + "target.csv");
        try (BufferedReader read = new BufferedReader(
                new FileReader(path + "target.csv"))) {
            assertThat("10:57:01;10:59:01", is(read.readLine()));
            assertThat("11:01:02;11:02:02", is(read.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analysis.outPrintlnFile(source.getAbsolutePath());
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (var in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(result::add);
        }
        String expected = ("10:57:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02");
        assertThat(result.toString(), is(expected));
    }

    @After
    public void after() {
        File file = new File(path + "source.log");
        if (file.exists()) {
            file.deleteOnExit();
        }
        file = new File(path + "target.csv");
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
}
