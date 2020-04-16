package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Телефонный справочник.
 */
public class PhoneDictionary {
    /**
     * Список всех пользоватлей.
     */
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * Добавить абонента.
     *
     * @param person абонент
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Получить пользователей, содержащие key в любом из полей.
     *
     * @param key ключ поиска
     * @return список пользователей
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname.or(phone.or(address)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
