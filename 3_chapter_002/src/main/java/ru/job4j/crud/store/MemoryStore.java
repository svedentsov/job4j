package ru.job4j.crud.store;

import ru.job4j.crud.datamodel.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Реализация кеша для хранения пользователей в памяти.
 * Persistent layout - слой для хранения данных.
 * Может быть: базой данных, памятью или файловой системой.
 */
public class MemoryStore implements Store<User> {

    /**
     * Eager loading - энергичная загрузка, создаем и инициализируем объект сразу после старта виртуальной машины.
     */
    private static final MemoryStore INSTANCE = new MemoryStore();

    /**
     * Поле содержит хранилище пользователей.
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    /**
     * Поле содержит базовый id пользователя, который далее инкрементируется на 1.
     */
    private final AtomicInteger id = new AtomicInteger(0);

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        user.setId(id.getAndIncrement());
        this.users.put(user.getId(), user);
    }

    @Override
    public void update(User user, Integer id) {
        this.users.computeIfPresent(id, (key, value) -> {
            value.setName(user.getName());
            value.setLogin(user.getLogin());
            value.setEmail(user.getEmail());
            return value;
        });
    }

    @Override
    public void uploadImage(User user) {
        this.users.computeIfPresent(user.getId(), (key, value) -> {
            value.setPhotoId(user.getPhotoId());
            return value;
        });
    }

    @Override
    public void delete(Integer id) {
        this.users.remove(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.users.values());
    }

    @Override
    public User findById(int id) {
        return this.users.get(id);
    }
}
