package ru.job4j.stream;

/**
 * Профиль клиента.
 */
public class Profile {
    /**
     * Адрес проживания.
     */
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Profile(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profile{" + "address=" + address + '}';
    }
}
