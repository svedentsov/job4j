package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Список адресов клиентов.
 */
public class Profiles {
    /**
     * Создать список адресов из списка профилей.
     *
     * @param profiles список профилей.
     * @return список адресов.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
