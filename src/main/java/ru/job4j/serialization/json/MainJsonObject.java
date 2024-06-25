package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainJsonObject {
    public static void main(String[] args) {
        JSONObject jsonContactPhone = new JSONObject("{\"contactPhone\":\"89911\"}");

        List<String> list = new ArrayList<>();
        list.add("handyman");
        list.add("carpenter");
        list.add("foreman");
        JSONArray jsonStatus = new JSONArray(list);

        final PersonJson personJson = new PersonJson(true, 30, new ContactPhone("5423523"),
                new String[]{"Handyman", "Carpenter", "Foreman"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gender", personJson.isSex());
        jsonObject.put("age", personJson.getAge());
        jsonObject.put("contactPhone", jsonContactPhone);
        jsonObject.put("statuses", jsonStatus);
        System.out.println(jsonObject);

        System.out.println(new JSONObject(personJson));
    }
}
