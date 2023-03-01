package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String src = "C:\\MyProjects\\JavaRushTasks\\1.JavaSyntax\\src\\com\\javarush\\task\\pro\\task15\\task1504\\File1.txt";
        String dest = "C:\\MyProjects\\JavaRushTasks\\1.JavaSyntax\\src\\com\\javarush\\task\\pro\\task15\\task1504\\File2.txt";

        try (InputStream input = Files.newInputStream(Path.of(src));
             OutputStream output = Files.newOutputStream(Path.of(dest))) {


        }
    }
}

