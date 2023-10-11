package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<String> getData() {
        List<String> data = new ArrayList<String>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }
}
