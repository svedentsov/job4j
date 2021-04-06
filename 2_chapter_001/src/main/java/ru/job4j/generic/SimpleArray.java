package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleArray реализация простой массив.
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Массив всех элементов.
     */
    private final Object[] objects;
    /**
     * Индекс для корректного перемещения по массиву.
     */
    private int index = 0;

    /**
     * Конструктор класса создает новый SimpleArray заданного размера.
     *
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод добавляет указанный элемент (model) в первую свободную ячейку.
     *
     * @param model новый элемент.
     */
    public void add(T model) throws ArrayIndexOutOfBoundsException {
        this.objects[this.index++] = model;
    }

    /**
     * Метод заменяет указанным элементом (model) элемент, находящийся по индексу position.
     *
     * @param position позиция старого элемента.
     * @param model    новый элемент массива.
     */
    public void set(int position, T model) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        this.objects[position] = model;
    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу.
     *
     * @param position индекс для доступа к значению.
     * @return значение полученное по индексу.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * Метод удаляет элемент по указанному индексу.
     * Все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево.
     *
     * @param position позиция удаляемого элемента.
     */
    public void remove(int position) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        System.arraycopy(this.objects, position + 1, this.objects, position, index - position);
        this.objects[index] = null;
        index--;
    }

    /**
     * Метод выкидывает исключение, если индекс выходит за границу массива.
     */
    private void checkSizeContainer(int position) throws ArrayIndexOutOfBoundsException {
        if (position > this.index || this.index == 0) {
            throw new ArrayIndexOutOfBoundsException("Container empty or full");
        }
    }

    /**
     * Метод возвращает иттератор для обхода данной структуры.
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
                return (T) objects[iter++];
            }
        };
    }
}
