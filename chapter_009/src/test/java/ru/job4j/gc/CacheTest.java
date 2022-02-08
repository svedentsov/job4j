package ru.job4j.gc;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CacheTest {
    @Test
    public void whenFirstRequestThenLoadDataFromFileIntoCache() throws IOException {
        File temp = new File(
                System.getProperty("java.io.tmpdir")
                        + System.getProperty("file.separator")
        );

        File data = File.createTempFile("cache", ".txt", temp);
        String expected = String.join(System.lineSeparator(),
                "one",
                "two"
        );
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(data))) {
            bw.write(expected);
        }
        System.out.println(temp.getAbsolutePath());
        ICache cache = new Cache(temp.getAbsolutePath());
        String result = cache.getData(data.getName());

        assertThat(result, is(expected));
        data.deleteOnExit();
    }

    @Test
    public void whenSecondRequestThenGetDataFromCache() throws IOException {
        File temp = new File(
                System.getProperty("java.io.tmpdir")
                        + System.getProperty("file.separator")
        );
        File data = File.createTempFile("cache", ".txt", temp);
        String expected = String.join(System.lineSeparator(),
                "one",
                "two"
        );
        Files.write(data.toPath(), expected.getBytes());

        ICache cache = new Cache(temp.getAbsolutePath());
        cache.getData(data.getName());
        Files.write(data.toPath(), "new".getBytes());

        assertThat(cache.getData(data.getName()), is(expected));
        assertThat(Files.readString(data.toPath()), is("new"));
        data.deleteOnExit();
    }
}
