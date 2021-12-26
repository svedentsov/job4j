package ru.job4j.userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final Map<Integer, User> storage;

    public UserStorage() {
        this.storage = new HashMap<>();
    }

    public synchronized boolean add(User user) {
        boolean result = false;
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        if (storage.containsKey(user.getId())) {
            storage.remove(user.getId());
            result = true;
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (storage.containsKey(fromId)
                && storage.containsKey(toId)
                && storage.get(fromId).getAmount() >= amount) {
            storage.get(fromId).setAmount(storage.get(fromId).getAmount() - amount);
            storage.get(toId).setAmount(storage.get(toId).getAmount() + amount);
            result = true;
        }
        return result;
    }

    public synchronized Integer size() {
        return storage.size();
    }

    public synchronized User getUser(int key) {
        return storage.get(key);
    }

    public synchronized Map<Integer, User> getStorage() {
        return this.storage;
    }
}
