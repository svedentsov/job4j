package ru.job4j.search;

/**
 * Абонент.
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Конструктор абонента.
     *
     * @param name    имя
     * @param surname фамилия
     * @param phone   номер телефона
     * @param address адрес
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Получить имя абонента.
     *
     * @return имя абонента
     */
    public String getName() {
        return name;
    }

    /**
     * Получить фамилию абонента.
     *
     * @return фамилия абонента
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Получить номер телефона абонента.
     *
     * @return номер телефона абонента
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Получить адрес абонента.
     *
     * @return адрес абонента
     */
    public String getAddress() {
        return address;
    }
}
