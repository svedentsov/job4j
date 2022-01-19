package ru.job4j.crud.store;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.crud.datamodel.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Реализация кеша для хранения пользователей в памяти.
 * Persistent layout - слой для хранения данных.
 * Может быть: базой данных, памятью или файловой системой.
 */
@ThreadSafe
public class MemoryStore implements Store<User> {

    /**
     * Eager loading - энергичная загрузка, создаем и инициализируем объект сразу после старта виртуальной машины.
     */
    private static final MemoryStore INSTANCE = new MemoryStore();

    /**
     * Поле содержит хранилище пользователей.
     */
    @GuardedBy("this")
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        synchronized (this) {
            this.users.put(user.getId(), user);
        }
    }

    @Override
    public void update(User user) {
        synchronized (this) {
            this.users.put(user.getId(), user);
        }
    }

    @Override
    public void delete(User user) {
        synchronized (this) {
            this.users.remove(user.getId());
        }
    }

    @Override
    public List<User> findAll() {
        synchronized (this) {
            //return (List) this.users.values();
            return new ArrayList<>(this.users.values());
        }
    }

    @Override
    public User findById(int id) {
        synchronized (this) {
            return this.users.get(id);
        }
    }
}
