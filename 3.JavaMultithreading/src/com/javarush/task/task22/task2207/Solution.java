package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            Set<String> stringSet = new HashSet<>();
            while (reader.ready()) {
                String[] split = reader.readLine().trim().split(" ");
                for (String word : split) {
                    StringBuilder builder = new StringBuilder(word);
                    builder.reverse();
                    String reversedWord = builder.toString();
                    if (stringSet.contains(reversedWord)) {
                        stringSet.remove(reversedWord);
                        Pair pair = new Pair();
                        pair.first = word;
                        pair.second = reversedWord;
                        result.add(pair);
                    } else {
                        stringSet.add(word);
                    }
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
