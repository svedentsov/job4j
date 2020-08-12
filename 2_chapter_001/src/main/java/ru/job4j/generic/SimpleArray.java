package ru.job4j.generic;

/**
 * Класс SimpleArray. Обертка над массивом.
 */
public class SimpleArray<T> {
    /**
     * Размер массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Массив всех элементов.
     */
    private Object[] values;
    /**
     * Индекс для корректного перемещения по массиву.
     */
    private int index = 0;

    /**
     * Конструктор класса по умолчанию
     */
    public SimpleArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор класса создает новый SimpleArray с заданным размером.
     *
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.values = new Object[size];
    }

    /**
     * Метод добавляет новое значение в массив.
     *
     * @param value новый значение.
     */
    public void add(T value) {
        if (!this.validate(this.index)) {
            this.ensureCapacity();
        }
        this.values[this.index++] = value;
    }

    /**
     * Метод возвращает элемент по индексу.
     *
     * @param position индекс который используется для доступа к массиву.
     * @return значение полученное по индексу.
     */
    public T get(int position) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        return (T) this.values[position];
    }

    /**
     * Метод обновляет текущий элемент массива.
     *
     * @param position позиция старого элемента.
     * @param value    новое значение для элемента массива.
     */
    public void update(int position, T value) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        this.values[position] = value;
    }

    /**
     * Метод удаляет элемент в занной позиции.
     *
     * @param position позиция удаляемого элемента.
     */
    public void delete(int position) {
        if (!this.validate(position)) {
            throw new IllegalArgumentException("Out of bound");
        }
        this.values[position] = null;
        this.index--;
    }

    /**
     * Метод проверяет расположение значения между нулем и текущей длинной массива.
     *
     * @param position номер позиции для проверки.
     * @return true - если значение находится между нулем и длинной массива, иначе - false.
     */
    private boolean validate(int position) {
        return ((position >= 0) && (position < this.values.length));
    }

    /**
     * Метод увеличивает размер массива для корректного добавления нового значения.
     */
    private void ensureCapacity() {
        int length = (this.values.length * 3) / 2 + 1;
        Object[] expandValues = new Object[length];
        System.arraycopy(this.values, 0, expandValues, 0, this.values.length);
        this.index = this.values.length + 1;
        this.values = expandValues;
    }

    /**
     * Метод возвращает текущую длину массива.
     *
     * @return длинна массива.
     */
    public int size() {
        return this.values.length;
    }
}
