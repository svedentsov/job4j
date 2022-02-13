package ru.job4j.generic;

import org.junit.Test;
import ru.job4j.generic.model.User;
import ru.job4j.generic.service.UserStore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Класс тестирует функционал класса UserStore.
 */
public class UserStoreTest {
    @Test
    public void whenAddElementShouldGetSameElementById() {
        UserStore userStore = new UserStore(1);
        User user = new User("test");
        userStore.add(user);
        User result = userStore.findById("test");
        assertThat(result, is(user));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullContainerShouldReturnException() {
        UserStore userStore = new UserStore(1);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        userStore.add(user2);
    }

    @Test
    public void whenAddAndReplaceElementShouldReplaceIdAtFind() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        userStore.replace("test1", user2);
        User result = userStore.findById("test2");
        assertThat(result, is(user2));
    }

    @Test
    public void whenReplaceElementAndGetReplacedElementShouldReturnNull() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        User user2 = new User("test2");
        userStore.add(user1);
        assertTrue(userStore.replace("test1", user2));
        assertThat(userStore.findById("test2"), is(user2));
        assertNull(userStore.findById("test1"));
    }

    @Test
    public void whenRemoveWithoutAddElementsShouldReturnFalse() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        userStore.add(user1);
        assertFalse(userStore.delete("test2"));
    }

    @Test
    public void whenFindByIdCannotFindIdShouldReturnNull() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("test1");
        userStore.add(user1);
        assertNull(userStore.findById("test2"));
    }
}
