package ru.job4j.nonblockingalgorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CacheStoringModelsTest {

    private CacheStoringModels csm;
    private Base model;
    public ConcurrentHashMap<Integer, Base> map;

    @Before
    public void setUp() {
        csm = new CacheStoringModels();
        model = new Base(0, 0);
        map = new ConcurrentHashMap<>();
        csm.add(model);
    }

    @Test
    public void whenFirstUpdateModel() {
        csm.update(model);
        int key = 0;
        for (Map.Entry<Integer, Base> entry : csm.map.entrySet()) {
            key = entry.getValue().getVersion();
        }
        assertThat(1, is(key));
    }

    @Test
    public void whenDeleteModel() {
        csm.delete(model);
        assertThat(null, is(csm.map.get(0)));
    }

    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }
}
