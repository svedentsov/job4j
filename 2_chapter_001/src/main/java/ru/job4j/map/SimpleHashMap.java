package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер на базе ассоциативного массива, который хранит пары типа "ключ - значение".
 */
public class SimpleHashMap<K, V> implements Iterable {
    /**
     * Массив значений.
     */
    private Node<K, V>[] table;
    /**
     * Размер по умолчанию.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    /**
     * Количество элементов в массиве.
     */
    private int size = 0;
    /**
     * Размер массива.
     */
    private int capacity;

    /**
     * Конструктор.
     */
    public SimpleHashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        table = new Node[capacity];
    }

    /**
     * Метод позволяет добавить элемент в коллекцию по ключу.
     * Вставка осуществляется по индексу, который рассчитывается по значению хэш-кода ключа и размеру массива.
     *
     * @param key   ключ
     * @param value значение
     * @return true - вставка производится, false - вставка не производится, ячейка с таким индексом уже заполнена
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        Node<K, V> e;
        if (size >= 0.75 * capacity) {
            resize();
        }
        int i = getIndex(key);
        if (table[i] == null) {
            table[i] = new Node<>(key.hashCode(), key, value, null);
            size++;
        } else {
            e = table[i];
            if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
                e.value = value;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Найти значение из коллекции по ключу.
     *
     * @param key ключ значения
     * @return найденное значение
     */
    public V get(K key) {
        V result = null;
        int i = getIndex(key);
        Node<K, V> e = table[i];
        if (e != null) {
            if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
                result = e.value;
            }
        }
        return result;
    }

    /**
     * Удалить значение из коллекции по ключу.
     *
     * @param key ключ значения
     * @return найденное значение
     */
    public boolean delete(K key) {
        boolean result = false;
        int i = getIndex(key);
        Node<K, V> e = table[i];
        if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
            table[i] = null;
            result = true;
            size--;
        }
        return result;
    }

    /**
     * Получить индекс ключа массива, для которого вычисляется хэш-код.
     *
     * @param key ключ
     * @return индекс
     */
    private int getIndex(K key) {
        return key.hashCode() & (capacity - 1);
    }

    /**
     * Получить количество элементов в массиве.
     *
     * @return количество элементов
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Получить длину массива.
     *
     * @return длина массива
     */
    public int getLength() {
        return table.length;
    }

    /**
     * Увеличить размер массива при его переполнении.
     */
    private void resize() {
        capacity *= 2;
        size = 0;
        Node<K, V>[] oldTable = table;
        table = new Node[capacity];
        for (Node<K, V> e : oldTable) {
            if (e != null) {
                insert(e.key, e.value);
            }
        }
    }

    /**
     * Node - контейнер.
     *
     * @param <K> ключ
     * @param <V> значение
     */
    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V getValue() {
            return value;
        }
    }

    /**
     * Итератор.
     *
     * @return переопределенный итератор
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index;
            Node<K, V> e = table[index];

            @Override
            public boolean hasNext() {
                while ((index < (capacity - 1)) && e == null) {
                    index++;
                    e = table[index];
                }
                return e != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                Node<K, V> result = e;
                if (e.next != null) {
                    e = e.next;
                } else {
                    while (index < capacity - 1) {
                        index++;
                        e = table[index];
                        if (e != null) {
                            break;
                        }
                    }
                }
                return result;
            }
        };
    }
}
