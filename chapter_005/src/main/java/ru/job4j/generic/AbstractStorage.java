package ru.job4j.generic;

import java.util.Iterator;

/**
 * Класс реализует общий функционал для классов UserStore и RoleStore.
 */
public abstract class AbstractStorage<T extends Base> implements Store<T> {
    /**
     * Хранилище объектов.
     */
    private final SimpleArray<T> container;

    public AbstractStorage(int size) {
        this.container = new SimpleArray<>(size);
    }

    /**
     * Получить индекс элемента массива по-указанному id элемента.
     */
    private int getIndex(String id) {
        int index = 0;
        boolean exist = false;
        for (T model : container) {
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

    @Override
    public void add(T model) {
        this.container.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.container.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.container.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return null;
        }
        return this.container.get(index);
    }

    @Override
    public Iterator<T> iter() {
        return container.iterator();
    }
}
