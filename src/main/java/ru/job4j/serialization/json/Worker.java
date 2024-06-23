package ru.job4j.serialization.json;

import java.util.Arrays;

public class Worker {
    private final boolean gender;
    private final int age;
    private final Phone phone;
    private final String[] skills;

    public Worker(boolean gender, int age, Phone phone, String[] skills) {
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Worker{"
                + "gender=" + gender
                + ", age=" + age
                + ", phone=" + phone
                + ", skills=" + Arrays.toString(skills)
                + '}';
    }
}
