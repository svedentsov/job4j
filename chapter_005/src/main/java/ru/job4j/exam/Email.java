package ru.job4j.exam;

import java.util.*;

/**
 * Класс реализует алгоритм, выполняющий слияние пользователей по их email-ам.
 * Если у двух пользователей есть общий email, значит это один и тот же пользователь.
 */
public class Email {
    /**
     * Объединить пользователей по адресу электронной почты.
     *
     * @param users пользователи
     * @return список пользователей с их email-ами
     */
    public static Map<String, Set<String>> merge(List<User> users) {
        Map<String, String> storeUniqueEmails = new HashMap<>();
        Map<String, Set<String>> mergedUsers = new HashMap<>();

        for (User u : users) {
            String name = u.name;
            for (String email : u.emails) {
                if (storeUniqueEmails.containsKey(email)) {
                    name = storeUniqueEmails.get(email);
                    break;
                }
            }
            for (String email : u.emails) {
                storeUniqueEmails.put(email, name);
            }
            if (mergedUsers.containsKey(name)) {
                mergedUsers.get(name).addAll(u.emails);
            } else {
                mergedUsers.put(name, new LinkedHashSet<>(u.emails));
            }
        }
        return mergedUsers;
    }

    /**
     * Класс описывание отдельного пользователя.
     */
    public static class User {
        /**
         * Имя пользователя.
         */
        String name;
        /**
         * Электронная почта.
         */
        List<String> emails;

        public User(String name, List<String> emails) {
            this.name = name;
            this.emails = emails;
        }
    }
}
