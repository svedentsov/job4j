package ru.job4j.generic;

/**
 * Хранилище пользователей.
 */
public class UserStore extends AbstractStorage<User> {
    public UserStore(int size) {
        super(size);
    }
}
