package ru.job4j.generic;

import java.util.Iterator;

/**
 * Сделать интерфейс Store<T extends Base>, где Base - это абстрактный класс для моделей c методами String getId();
 * 1) Сделать два класса User, и Role, которые наследуют Base класс.
 * 2) Сделать два класса хранилища UserStore и RoleStore. Внутри для хранения данных использовать SimpleArray.
 * 3) Помните. про инкапсуляцию. Вам нельзя изменять интерфейс Store. Например. replace(int index,  T model) - нельзя делать. Так как мы изменили входящий параметр.
 * 4) После реализации проверьте можно ли избавиться от дублирования кода в вашем проекте. UserStore и RoleStore будут иметь один и тот же функционал. Общий для них функционал необходимо вынести в абстрактный класс AbstractStore.
 * 5) Помните, что хранилище должны быть жестко ограничены хранимым типом. Например для UserStore тип хранимых данных должен быть User.
 * <p>
 * Класс реализует общий функционал для классов UserStore и RoleStore.
 */
public abstract class AbstractStorage<T extends Base> implements Store<T> {

    /**
     * Хранилище объектов.
     */
    private final SimpleArray<T> container;

    /**
     * Конструктор нового хранилища с заданным размером.
     *
     * @param size размер хранилища
     */
    public AbstractStorage(int size) {
        this.container = new SimpleArray<>(size);
    }

    /**
     * Получить индекс элемента массива по указанному id элемента.
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
