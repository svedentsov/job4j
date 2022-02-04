package ru.job4j.generic;

/**
 * Класс для хранения данных.
 * Инициализирует конструктор абстрактного суперкласса AbstractStorage.
 * Функционал класса вынесен в абстрактный суперкласс AbstractStorage.
 * Тип хранимых данных должен быть Role.
 */
public class RoleStore extends AbstractStorage<Role> {
    public RoleStore(int size) {
        super(size);
    }
}
