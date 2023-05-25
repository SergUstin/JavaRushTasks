package com.javarush.task.task18.task1816;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Английские буквы
*/

public class Solution {

    private final static Character[] ENGLISH_CHARACTERS_ARRAY = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'
            , 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c'
            , 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'
            , 'x', 'y', 'z'};
    private final static Set<Character> ENGLISH_CHARACTERS = new HashSet<>(Arrays.asList(ENGLISH_CHARACTERS_ARRAY));

    public static void main(String[] args) throws IOException {
        int countOfEnglichChars = 0;
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                char readChar = (char) reader.read();
                if (ENGLISH_CHARACTERS.contains(readChar)) {
                    countOfEnglichChars++;
                }
            }
        }
        System.out.println(countOfEnglichChars);
        
    }
}
