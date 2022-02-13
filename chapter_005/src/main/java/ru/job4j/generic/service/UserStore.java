package ru.job4j.generic.service;

import ru.job4j.generic.model.User;
import ru.job4j.generic.service.AbstractStorage;

/**
 * Хранилище объектов типа User.
 */
public class UserStore extends AbstractStorage<User> {
    public UserStore(int size) {
        super(size);
    }
}
