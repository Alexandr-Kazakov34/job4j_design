package ru.job4j.serialization.json;

public class ContactPhone {
    private final String contactPhone;

    public ContactPhone(String phone) {
        this.contactPhone = phone;
    }

    @Override
    public String toString() {
        return "ContactPhone{"
                + "contactPhone='" + contactPhone + '\''
                + '}';
    }
}
