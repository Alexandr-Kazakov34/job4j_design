package ru.job4j.serialization.json;

import ru.job4j.serialization.java.Contact;

import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int age;
    private final ContactPhone contactPhone;
    private final String[] statuses;

    public Person(boolean sex, int age, ContactPhone contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contactPhone = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contactPhone=" + contactPhone
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}