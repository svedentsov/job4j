package ru.job4j.io.zip;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgZipTest {
    private ArgZip argZip;

    @Before
    public void setUp() {
        String[] args = new String[]{"-d", "./2_chapter_002", "-e", "class,xml", "-o", "2_chapter_002.zip"};
        argZip = new ArgZip(args);
    }

    @Test
    public void whenGetDirectory() {
        String directory = argZip.getDirectory();
        assertEquals(directory, "./2_chapter_002");
    }

    @Test
    public void whenGetListExclude() {
        List<String> exclude = argZip.getExclude();
        assertEquals(exclude, List.of("class", "xml"));
    }

    @Test
    public void whenGetOutput() {
        String output = argZip.getOutput();
        assertEquals(output, "2_chapter_002.zip");
    }
}
