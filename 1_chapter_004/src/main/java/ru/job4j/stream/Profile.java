package ru.job4j.stream;

/**
 * Профиль клиента.
 */
public class Profile {
    /**
     * Адрес проживания.
     */
    private Address address;

    /**
     * Получить адрес проживания.
     *
     * @return адрес проживания.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Конструктор профиля клиента.
     *
     * @param address адрес клиента.
     */
    public Profile(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profile{" + "address=" + address + '}';
    }
}
