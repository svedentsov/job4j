package ru.job4j.map;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * 5. Перекрывать equals и hashCode.
 * Теперь переопределили и equals и hashCode. При вставке в map хэшы получились одинаковыми, затем идет проверка по иквелс.
 * Иквелс подтверждает что обьекты одинаковы. И первай элемент мэпа затирается вторым, так как ключи одинаковы.
 * В консоль выводится один элемент
 * <p>
 * Модель типового пользователя.
 */
public class User {

    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Количество детей пользователя.
     */
    private int children;
    /**
     * Дата рождения пользователя.
     */
    private Calendar birthday;

    /**
     * Конструктор, инициализирующий пользователя по трем параметрам.
     *
     * @param name     имя пользователя.
     * @param children количество детей пользователя.
     * @param birthday дата рождения пользователя.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return "Name = " + name + " | "
                + "Children = " + children + " | "
                + "Birthday = " + df.format(birthday.getTime());
    }
}
