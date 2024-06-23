package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final PersonJson person = new PersonJson(false, 30, new ContactPhone("11-111"),
                new String[] {"Worker", "Married"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Создаём новую json-строку с модифицированными данными*/
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contactPhone\":"
                        + "{"
                        + "\"contactPhone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        /* Превращаем json-строку обратно в объект */
        final PersonJson personMod = gson.fromJson(personJson, PersonJson.class);
        System.out.println(personMod);
    }
}