package com.javarush.task.pro.task15.task1503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Если ресурсов много
*/

public class Solution {
    public static void main(String[] args) {
//        Scanner scanner = null;
//        BufferedReader bufferedReader = null;
//        try {
//            scanner = new Scanner(System.in);
//            String fileName = scanner.nextLine();
//            bufferedReader = Files.newBufferedReader(Path.of(fileName));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Something went wrong : " + e);
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//        }

        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = Files.newBufferedReader(Path.of(scanner.nextLine()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

