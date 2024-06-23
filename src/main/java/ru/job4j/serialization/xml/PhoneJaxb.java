package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phoneJaxb")
public class PhoneJaxb {
    @XmlAttribute
    private String phone;

    public PhoneJaxb() {
    }

    public PhoneJaxb(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhoneJaxb{"
                + "phone='" + phone + '\''
                + '}';
    }
}
