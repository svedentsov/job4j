package ru.job4j.pojo;

import java.util.Date;

public class Student {

    private String fullName;
    private int group;
    private Date created;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGroup() {
        return group;
    }

    public Date getCreated() {
        return created;
    }
}
