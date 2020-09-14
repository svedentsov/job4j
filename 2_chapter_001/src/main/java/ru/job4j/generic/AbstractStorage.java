package ru.job4j.generic;

import java.util.Iterator;

/**
 * Класс реализует общий функционал для классов UserStore и RoleStore.
 */
public abstract class AbstractStorage<T extends Base> implements Store<T> {
    /**
     * Хранилище объектов типа T.
     */
    private final SimpleArray<T> simpleArray;

    /**
     * Конструктор нового хранилища с заданным размером.
     *
     * @param size размер хранилища
     */
    public AbstractStorage(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Получить индекс элемента массива по указанному id элемента.
     */
    private int getIndex(String id) {
        int index = 0;
        boolean exist = false;
        for (T model : simpleArray) {
            if (model.getId().equals(id)) {
                exist = true;
                break;
            }
            index++;
        }
        if (!exist) {
            index = -1;
        }
        return index;
    }

    /**
     * Добавить указанный элемент в массив.
     *
     * @param model объект
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    /**
     * Заменить указанным элементов элемент массива.
     *
     * @param id    идентификатор заменяемого объекта
     * @param model новый элемент
     * @return true - значение заменено, иначе false
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1){
            this.simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    /**
     * Удалить элемент массива, определяя его индекс по id.
     *
     * @param id идентификатор удаляемого элемента.
     * @return true - элемент удален, иначе - false.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.simpleArray.remove(index);
            result = true;
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
        int index = getIndex(id);
        if (index == -1) {
            return null;
        }
        return this.simpleArray.get(index);
    }

    /**
     * return Итератор хранилища.
     */
    @Override
    public Iterator<T> iter() {
        return simpleArray.iterator();
    }
}
