package ru.job4j.generic.service;

import ru.job4j.generic.model.Role;

/**
 * Хранилище объектов типа Role.
 */
public class RoleStore extends AbstractStorage<Role> {
    public RoleStore(int size) {
        super(size);
    }
}
