package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализует универсальную обертку над массивом.
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
     * Добавить элемент в первую свободную ячейку.
     *
     * @param model новый значение.
     */
    public void add(T model) throws ArrayIndexOutOfBoundsException {
        this.objects[this.index++] = model;
    }

    /**
     * Заменить элемент находящийся по указанному индексу.
     *
     * @param position позиция старого элемента
     * @param model    новое значение для элемента массива
     */
    public void set(int position, T model) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        this.objects[position] = model;
    }

    /**
     * Получить элемент находящийся по указанному индексу.
     *
     * @param position индекс для доступа к значению.
     * @return значение полученное по индексу.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * Удалить элемент по указанному индексу.
     * Все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево.
     *
     * @param position позиция удаляемого элемента
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
     * Получить текущую длину массива.
     *
     * @return длинна массива
     */
    public int size() {
        return this.objects.length;
    }

    /**
     * Метод возвращает иттератор для обхода данной структуры.
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(index, (Iterator<T>) Arrays.asList(this.objects).iterator());
    }

    /**
     * Класс реализует итератор для массива.
     */
    private class SimpleArrayIterator implements Iterator<T> {

        private final int size;
        private int index = 0;
        private final Iterator<T> arrayIterator;

        public SimpleArrayIterator(int size, Iterator<T> arrayIterator) {
            this.size = size;
            this.arrayIterator = arrayIterator;
        }

        @Override
        public boolean hasNext() {
            return (index <= size - 1) && arrayIterator.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no any next element");
            }
            index++;
            return arrayIterator.next();
        }
    }
}
