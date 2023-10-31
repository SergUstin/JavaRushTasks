package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return numberOfPossibleAscents(n, memo);
    }

    private static long numberOfPossibleAscents(int n, long[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = numberOfPossibleAscents(n - 1, memo)
                    + numberOfPossibleAscents(n - 2, memo)
                    + numberOfPossibleAscents(n - 3, memo);
            return memo[n];
        }
    }
}

