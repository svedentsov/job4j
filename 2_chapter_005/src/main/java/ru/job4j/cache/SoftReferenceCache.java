package ru.job4j.cache;

public interface SoftReferenceCache<T, V> {
    V getValue(T key);
}
