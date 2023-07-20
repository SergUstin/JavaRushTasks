package com.javarush.task.task19.task1918;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
        }

        StringBuilder readFileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
        }

        String fileContent = readFileContent.toString().replaceAll("[\\r\\n]+", "");

        String tag = args[0];
        String openedTag = "<" + tag;
        String closedTag = "</" + tag;
        int openedTagIndex = fileContent.indexOf(openedTag);
        int closedTagIndex = fileContent.indexOf(closedTag);
        ArrayList<Integer> openedTagsIndexes = new ArrayList<>();
        ArrayList<Integer> closedTagsIndexes = new ArrayList<>();

        while (openedTagIndex != -1 || closedTagIndex != -1) {
            if (openedTagIndex != -1 && openedTagIndex < closedTagIndex) {
                openedTagsIndexes.add(openedTagIndex);
                openedTagIndex = fileContent.indexOf(openedTag, openedTagIndex + 1);
            } else if (closedTagIndex < openedTagIndex || openedTagIndex == -1) {
                closedTagsIndexes.add(closedTagIndex + tag.length() + 3);
                closedTagIndex = fileContent.indexOf(closedTag, closedTagIndex + 1);
            }
        }

        Stack<String> stack = new Stack<>();
        for (int i = openedTagsIndexes.size() - 1; i >= 0; i--) {
            stack.push(fileContent.substring(openedTagsIndexes.get(i), getNextCloseTag(closedTagsIndexes, openedTagsIndexes.get(i))));
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    private static int getNextCloseTag(ArrayList<Integer> closedTagsIndexes, Integer openTagIndex) {
        Iterator<Integer> iterator = closedTagsIndexes.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > openTagIndex) {
                iterator.remove();
                return next;
            }
        }
        return 0;
    }
}
