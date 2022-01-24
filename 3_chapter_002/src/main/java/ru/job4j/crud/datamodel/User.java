package ru.job4j.crud.datamodel;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель пользователя.
 */
public class User {

    private Integer id;
    private String name;
    private String login;
    private String email;
    private LocalDateTime createDate;
    private String photoId;
    private String password;
    private Role role;

    public User() {
    }

    public User(Integer id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

    public User(Integer id, String name, String login, String email, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public User(Integer id, String name, String login, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = LocalDateTime.now();
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String name, String login, String email, LocalDateTime createDate, String password, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String name, String login, String email, LocalDateTime createDate, String photoId, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.photoId = photoId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return id.equals(user.id)
                && name.equals(user.name)
                && login.equals(user.login)
                && email.equals(user.email)
                && createDate.equals(user.createDate)
                && password.equals(user.password)
                && role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, createDate, password, role);
    }

    @Override
    public String toString() {
        return String.format("User{ id=%d, name=%s, login=%s, email=%s, createDate=%s }",
                id, name, login, email, createDate);
    }
}
