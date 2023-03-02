package com.javarush.task.pro.task15.task1507;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Path.*;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> files = Files.readAllLines(Path.of(scanner.nextLine()));

        for (int i = 0; i < files.size(); i += 2) {
            System.out.println(files.get(i));
        }
    }
}

