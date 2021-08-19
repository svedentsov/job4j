package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class SearchTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void addFiles() throws IOException {
        folder.newFile("test1.java");
        folder.newFile("test2.txt");
        folder.newFile("test3.js");
        folder.newFile("test4.java");
        folder.newFile("test5.jpg");
        folder.newFile("test6.js");
    }

    @Test
    public void whenTestSearch() throws IOException {
        Path source = Paths.get(folder.getRoot().toString());
        List<Path> expected = List.of(
                Path.of(folder.getRoot() + "/test1.java"),
                Path.of(folder.getRoot() + "/test4.java")
        );
        List<Path> result = new Search()
                .search(source, p -> p.toFile().getName().endsWith("java"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenFileNotFoundTest() throws IOException {
        Path source = Paths.get(folder.getRoot().toString());
        List<Path> result = new Search().search(source, p -> p.toFile().getName().endsWith("pdf"));
        assertTrue(result.isEmpty());
    }
}
