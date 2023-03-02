package com.javarush.task.pro.task15.task1510;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] bytes = args[0].getBytes();
//        try (InputStream stream = System.in;
//             InputStreamReader reader = new InputStreamReader(stream);
//             Scanner scanner = new Scanner(reader);
//             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(scanner.nextLine()))) {
//            bufferedWriter.write(bytes);
//        } catch (IOException e) {
//            System.out.println("Something went wrong : " + e);
//        }

        Scanner scanner = new Scanner(System.in);
        Files.write(Path.of(scanner.nextLine()), bytes);



    }
}

