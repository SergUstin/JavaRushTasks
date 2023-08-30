package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите полный путь архива: ");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String path  = console.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        System.out.println("Введите путь для архива: ");
        String src = console.readLine();
        zipFileManager.createZip(Paths.get(src));

    }
}
