package ru.job4j.serialization.json;

import java.util.Arrays;

public class PersonJson {
    private final boolean sex;
    private final int age;
    private final ContactPhone contactPhone;
    private final String[] statuses;

    public PersonJson(boolean sex, int age, ContactPhone contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contactPhone = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "PersonJson{"
                + "sex=" + sex
                + ", age=" + age
                + ", contactPhone=" + contactPhone
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }


    public String[] getStatuses() {
        return statuses;
    }

    public ContactPhone getContactPhone() {
        return contactPhone;
    }
}