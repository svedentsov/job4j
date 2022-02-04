package ru.job4j.io.duplicates;

import java.util.Objects;

/**
 * Модель данных файла, которая описывается двумя свойствами: размер и имя.
 */
public class FileProperty {

    private final long size;
    private final String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
