package ru.job4j.crud.store;

import ru.job4j.crud.datamodel.User;

import java.util.List;

/**
 * Описывает хранилище пользователей.
 */
public interface Store<T extends User> {

    void add(T user);

    void update(T user);

    void delete(T user);

    List<T> findAll();

    T findById(int id);
}
