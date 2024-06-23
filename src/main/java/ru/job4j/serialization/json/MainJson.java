package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainJson {
    public static void main(String[] args) {
        final Worker worker = new Worker(false, 35, new Phone("911"),
                new String[]{"handyman", "carpenter", "foreman"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(worker));
        final String workerJson =
                "{"
                        + "\"gender\":false,"
                        + "\"age\":40,"
                        + "\"phone\":"
                        + "{"
                        + "\"phone\":\"119\""
                        + "},"
                        + "\"skills\":"
                        + "[\"foreman\",\"carpenter\",\"handyman\"]"
                        + "}";


        final Worker workerMod = gson.fromJson(workerJson, Worker.class);
        System.out.println(workerMod);
    }
}