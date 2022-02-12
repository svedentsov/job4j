package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Составляет список адресов клиентов из списка анкет.
 */
public class Profiles {
    /**
     * Создание списка адресов из списка профилей.
     *
     * @param profiles список профилей.
     * @return список адресов.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
