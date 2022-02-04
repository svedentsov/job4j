package ru.job4j.generic;

/**
 * Класс для хранения данных.
 * Инициализирует конструктор абстрактного суперкласса AbstractStorage.
 * Функционал класса вынесен в абстрактный суперкласс AbstractStore.
 * Тип хранения данных должен быть User.
 */
public class UserStore extends AbstractStorage<User> {
    public UserStore(int size) {
        super(size);
    }
}
