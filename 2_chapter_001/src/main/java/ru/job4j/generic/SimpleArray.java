package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleArray. Обертка над массивом.
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Размер массива по умолчанию.
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     * Массив всех элементов.
     */
    private Object[] array;
    /**
     * Индекс для корректного перемещения по массиву.
     */
    private int index = 0;

    /**
     * Конструктор по умолчанию.
     */
    public SimpleArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * Конструктор класса создает новый SimpleArray с заданным размером.
     *
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Добавить новое значение в массив.
     *
     * @param value новый значение.
     */
    public void add(T value) {
        if (!this.validate(this.index)) {
            this.ensureSize();
        }
        this.array[this.index++] = value;
    }

    /**
     * Получить элемент по индексу.
     *
     * @param index индекс который используется для доступа к массиву.
     * @return значение полученное по индексу.
     */
    public T get(int index) {
        if (!this.validate(index)) {
            throw new IllegalArgumentException("Out of bound");
        }
        return (T) this.array[index];
    }

    /**
     * Записать элемент по индексу.
     *
     * @param index позиция старого элемента.
     * @param model новое значение для элемента массива.
     */
    public void set(int index, T model) {
        if (!this.validate(index)) {
            throw new IllegalArgumentException("Out of bound");
        }
        this.array[index] = model;
    }

    /**
     * Удалить элемент по индексу.
     *
     * @param index позиция удаляемого элемента.
     */
    public void delete(int index) {
        if (!this.validate(index)) {
            throw new IllegalArgumentException("Out of bound");
        }
        int nextIndex = index + 1;
        System.arraycopy(array, nextIndex, array, index, array.length - (index + 1));
        this.index--;
    }

    /**
     * Проверить расположение значения между нулем и текущей длинной массива.
     *
     * @param position номер позиции для проверки.
     * @return true - если значение находится между нулем и длинной массива, иначе - false.
     */
    private boolean validate(int position) {
        return ((position >= 0) && (position < this.array.length));
    }

    /**
     * Увеличить размер массива для корректного добавления нового значения.
     */
    private void ensureSize() {
        int length = (this.array.length * 3) / 2 + 1;
        Object[] expandValues = new Object[length];
        System.arraycopy(this.array, 0, expandValues, 0, this.array.length);
        this.index = this.array.length + 1;
        this.array = expandValues;
    }

    /**
     * Получить текущую длину массива.
     *
     * @return длинна массива.
     */
    public int size() {
        return this.array.length;
    }

    /**
     * Итератор.
     *
     * @return Итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iter = 0;

            @Override
            public boolean hasNext() {
                return (iter < index);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[iter++];
            }
        };
    }
}
