package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (!previousMap.containsKey(user.getId())) {
                added++;
            } else if (!previousMap.get(user.getId()).equals(user.getName())) {
                changed++;
            }
            previousMap.remove(user.getId());
            deleted = previousMap.size();
        }
        return new Info(added, changed, deleted);
    }
}