package com.javarush.task.pro.task15.task1502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Возврат к истокам
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        try (Scanner scanner = new Scanner(System.in)) {
//            String line = scanner.nextLine();
//            System.out.println(line.toUpperCase());
//        } catch (Exception e) {
//            System.out.println("Something went wrong : " + e);
//        }

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            System.out.println(line.toUpperCase());
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
