package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "personJaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonJaxb {
    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private PhoneJaxb contact;

    private String[] statuses;

    public PersonJaxb() {
    }

    public PersonJaxb(boolean sex, int age, PhoneJaxb contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "PersonJaxb{"
                + "sex=" + sex
                + ", age=" + age
                + ", phoneJaxb=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }


    public static void main(String[] args) throws JAXBException {

        final PersonJaxb person = new PersonJaxb(false, 30, new PhoneJaxb("911"), "handyman", "carpenter", "foreman");

        JAXBContext context = JAXBContext.newInstance(PersonJaxb.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            PersonJaxb result = (PersonJaxb) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }

}

