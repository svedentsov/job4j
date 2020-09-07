package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenNotOverrideEqualsAndHashcode() {
        Calendar calendar = new GregorianCalendar(1990, 1, 25);
        User user1 = new User("Ivan", 0, calendar);
        User user2 = new User("Ivan", 0, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User user : map.keySet()) {
            System.out.println(user);
        }
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
