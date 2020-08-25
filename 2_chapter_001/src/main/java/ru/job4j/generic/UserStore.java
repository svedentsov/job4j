package ru.job4j.generic;

public class UserStore extends AbstractStorage<User> {
    public UserStore(int size) {
        super(size);
    }
}
