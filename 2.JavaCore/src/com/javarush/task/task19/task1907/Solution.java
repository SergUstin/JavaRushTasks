package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        int count = 0;
//        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
//            while (reader.ready()) {
//                String string = reader.readLine();
//                String replaced = string.replaceAll("\\p{P}", " ");
//                String[] strings = replaced.split(" ");
//                for (String str : strings) {
//                    if (str.equals("world")) {
//                        count++;
//                    }
//                }
//            }
//        }
//        System.out.println(count);

        System.out.println(Arrays.stream(Files.readString(Path.of(new Scanner(System.in).nextLine()))
                .replaceAll("\\p{P}", " ").split(" ")).filter(str -> str.equals("world")).count());
    }
}
