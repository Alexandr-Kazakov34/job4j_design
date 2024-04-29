package ru.job4j.generic;

public class Role extends Base {
    private final String userName;

    public Role(String id, String name) {
        super(id);
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }
}
