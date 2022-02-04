package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Класс реализует статистику об изменении коллекции.
 */
public class Analize {
    /**
     * Получить статистику об изменении коллекции.
     *
     * @param previous исходное состояние коллекции
     * @param current  текущее состояние коллекции
     * @return объект класса Info, содержащий статистику по коллекции
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> usrMap = new HashMap<>();
        for (User prevUser : previous) {
            usrMap.put(prevUser.id, prevUser.name);
        }

        if (!usrMap.isEmpty() && current.size() == 0) {
            info.deleted = previous.size();
        }
        for (User curUser : current) {
            String s = usrMap.get(curUser.id);
            if (s == null) {
                info.added++;
            }
            if (s != null && !s.equals(curUser.name)) {
                info.changed++;
            }
        }
        info.deleted = previous.size() - current.size() + info.added;
        return info;
    }

    /**
     * Класс описывает отдельного пользователя.
     */
    public static class User {
        /**
         * Идентификатор пользователя.
         */
        int id;
        /**
         * Имя пользователя.
         */
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * Класс содержит статистику по коллекции.
     */
    public static class Info {
        /**
         * Число добавленных пользователей.
         */
        int added;
        /**
         * Число измененных пользователей.
         */
        int changed;
        /**
         * Число удаленных пользователей.
         */
        int deleted;
    }
}
