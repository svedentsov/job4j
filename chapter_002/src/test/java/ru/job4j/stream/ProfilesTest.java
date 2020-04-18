package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка класса Profiles.
 */
public class ProfilesTest {
    Profiles profiles = new Profiles();
    List<Profile> profileList = List.of(
            new Profile(new Address("Moscow", "Lenana", 12, 5)),
            new Profile(new Address("Saint Petersburg", "Puskina", 1, 31)),
            new Profile(new Address("Novosibirsk", "Kalinina", 11, 31))
    );

    /**
     * Создать список адресов из списка профилей.
     */
    @Test
    public void createAddressListFromProfileList() {
        List<Address> expected = Arrays.asList(
                new Address("Moscow", "Lenana", 12, 5),
                new Address("Saint Petersburg", "Puskina", 1, 31),
                new Address("Novosibirsk", "Kalinina", 11, 31)
        );
        List<Address> actual = profiles.collect(profileList);
        assertThat(actual, is(expected));
    }
}
