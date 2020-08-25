package ru.job4j.generic;

import java.util.Iterator;

/**
 * Модель хранилища, определяющая как хранить данные и получать доступ ко всем значениям массива.
 */
public abstract class AbstractStorage<T extends Base> implements Store<T> {
    /**
     * Размер хранилища по умолчанию.
     */
    private static final int DEFAULT_STORAGE_SIZE = 10;
    /**
     * Хранилище объектов типа T.
     */
    private final SimpleArray<T> array;

    /**
     * Конструктор по умолчанию.
     */
    public AbstractStorage() {
        this(DEFAULT_STORAGE_SIZE);
    }

    /**
     * Конструктор нового хранилища с заданным размером.
     *
     * @param size размер хранилища.
     */
    public AbstractStorage(int size) {
        this.array = new SimpleArray<>(size);
    }

    /**
     * Добавить в хранилище объект типа T.
     *
     * @param model объект.
     */
    @Override
    public void add(T model) {
        this.array.add(model);
    }

    /**
     * Заменить объект типа T по id.
     *
     * @param id    идентификатор заменяемого объекта.
     * @param model новый элемент.
     * @return true - значение заменено, иначе - false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (model != null) {
            for (int i = 0; i < this.array.size(); i++) {
                if (array.get(i) != null && array.get(i).getId().equals(id)) {
                    this.array.set(i, model);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Удалить объект типа T по id.
     *
     * @param id идентификатор удаляемого элемента.
     * @return true - элемент удален, иначе - false.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.array.size(); i++) {
            if (array.get(i) != null && array.get(i).getId().equals(id)) {
                array.delete(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Найти объект типа T по id.
     *
     * @param id идентификатор элемента.
     * @return найденный элемент.
     */
    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < this.array.size(); i++) {
            if (array.get(i) != null && array.get(i).getId().equals(id)) {
                result = array.get(i);
                break;
            }
        }
        return result;
    }
    /**
     * return Итератор хранилища.
     */
    @Override
    public Iterator<T> iter() {
        return array.iterator();
    }
}
