package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup(51);
        student.setCreated(new Date());

        System.out.println("Student: " + student.getFullName() + ". Group: " + student.getGroup() + ". Date of admission: " + student.getCreated());
    }
}
