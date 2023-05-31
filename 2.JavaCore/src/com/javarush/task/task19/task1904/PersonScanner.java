package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
