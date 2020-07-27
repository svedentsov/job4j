package ru.job4j.stream;

import java.util.Objects;

/**
 * Адрес проживания.
 */
public class Address {
    /**
     * Город.
     */
    private String city;
    /**
     * Улица.
     */
    private String street;
    /**
     * Номер дома.
     */
    private int home;
    /**
     * Номер квартиры.
     */
    private int apartment;

    /**
     * Конструктор адреса проживания
     *
     * @param city      город.
     * @param street    улица.
     * @param home      номер дома.
     * @param apartment номер квартиры.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\'' + ", street='" + street + '\'' + ", home=" + home + ", apartment=" + apartment + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
