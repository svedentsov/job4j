package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Конвертер Iterator<Iterator<Integer>> в Iterator<Integer>.
 */
public class Converter implements Iterator<Integer> {

    /**
     * Внутренний итератор.
     */
    private Iterator<Integer> innerIterator;

    /**
     * Внешний итератор.
     */
    private Iterator<Iterator<Integer>> outerIterator;

    /**
     * Конвертация Iterator<Iterator<Integer>> в Iterator<Integer>.
     *
     * @param it итератор итераторов.
     * @return итератор чисел с типом Integer.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.outerIterator = it;
        if (it == null) {
            throw new IllegalArgumentException("Iterator not allow null");
        }
        return this;
    }

    /**
     * Проверить наличие следующего элемента в итераторе.
     *
     * @return true - если есть элементы в текущем итераторе, иначе - false.
     */
    @Override
    public boolean hasNext() {
        if ((this.innerIterator == null) || (!this.innerIterator.hasNext() && this.outerIterator.hasNext())) {
            this.innerIterator = this.outerIterator.next();
        }
        return this.innerIterator.hasNext();
    }

    /**
     * Получить следующее значение итератора.
     *
     * @return следующий элемент.
     */
    @Override
    public Integer next() {
        if ((innerIterator == null) || (!this.innerIterator.hasNext())) {
            innerIterator = outerIterator.next();
        }
        return this.innerIterator.next();
    }
}
