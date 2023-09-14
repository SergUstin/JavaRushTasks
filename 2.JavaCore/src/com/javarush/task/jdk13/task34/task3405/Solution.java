package com.javarush.task.jdk13.task34.task3405;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нарушение приватности
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        User user = new User("Amigo", 21);
        print(getFields(user));

        Task task = new Task("task3405", true);
        print(getFields(task));
    }

    public static Map<String, Object> getFields1(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(object);
                map.put(key, value);
            }
        }
        return map;
    }

    public static Map<String, Object> getFields(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Arrays.stream(object.getClass().getDeclaredFields()).filter(field -> Modifier.isPrivate(field.getModifiers()))
                .map(field -> {
                    try {
                        return map.put(field.getName(), field.get(object));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
        return map;
    }

    public static void print(Map<?, ?> fields) {
        System.out.println("-------------------");
        fields.forEach((fieldName, fieldValue) -> System.out.println(fieldName + " = " + fieldValue));
    }
}
