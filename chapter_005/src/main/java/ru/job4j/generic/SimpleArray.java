package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * В этом задании необходимо сделать универсальную обертку над массивом.
 * Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.
 * Объект должен принимать количество ячеек. Структура не должна быть динамической. Если идет переполнение надо выкинуть ошибку.
 * <p>
 * Класс реализует универсальную обертку над массивом.
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Массив для хранения объектов.
     */
    private final Object[] array;
    /**
     * Индекс текущей ячейки массива.
     */
    private int index = 0;

    /**
     * Конструктор, инициализирующий массив с размеров size.
     *
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Добавить элемент в массив. После каждого добавления значение индекса увеличивается.
     *
     * @param model новый элемент
     */
    public void add(T model) throws ArrayIndexOutOfBoundsException {
        this.array[this.index++] = model;
    }

    /**
     * Метод заменяет указанным элементом (model) элемент, находящийся по индексу position.
     *
     * @param position позиция старого элемента
     * @param model    новый элемент массива
     */
    public void set(int position, T model) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        this.array[position] = model;
    }

    /**
     * Получить элемент, расположенный по указанному индексу.
     *
     * @param index индекс для доступа к значению.
     * @return значение полученное по индексу.
     */
    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * Удалить элемент по указанному индексу.
     * Все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево.
     *
     * @param position позиция удаляемого элемента.
     */
    public void remove(int position) throws ArrayIndexOutOfBoundsException {
        checkSizeContainer(position);
        System.arraycopy(this.array, position + 1, this.array, position, index - position);
        this.array[index] = null;
        index--;
    }

    /**
     * Получить исключение, если индекс выходит за границу массива.
     */
    private void checkSizeContainer(int position) throws ArrayIndexOutOfBoundsException {
        if (position > this.index || this.index == 0) {
            throw new ArrayIndexOutOfBoundsException("Container empty or full");
        }
    }

    /**
     * Получить итератор для обхода данной структуры.
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
