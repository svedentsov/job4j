package ru.job4j.crud.logic;

import ru.job4j.crud.datamodel.User;

import java.util.List;

public interface Validate<T extends User> {

    Boolean add(T user);

    Boolean update(T user, Integer id);

    Boolean uploadImage(T user);

    Boolean delete(Integer id);

    List<T> findAll();

    T findById(int id);

    T findByLogin(String login);

    T isCredential(String login, String password);
}
