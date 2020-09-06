package ru.job4j.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public Calendar getBirthday() {
        return birthday;
    }

    public int getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setName(String name) {
        this.name = name;
    }
}
