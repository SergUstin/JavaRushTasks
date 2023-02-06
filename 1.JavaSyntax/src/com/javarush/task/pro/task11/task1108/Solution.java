package com.javarush.task.pro.task11.task1108;

/* 
Утильный калькулятор
*/

public class Solution {
    public static final String EQUAL = " = ";

    public static void main(String[] args) {
        int a = 45;
        int b = 15;
        Solution.Calculator.add(a, b);
        Solution.Calculator.subtract(a, b);
        Solution.Calculator.multiply(a, b);
        Solution.Calculator.divide(a, b);
    }

    static class Calculator {

        public static void add(int a, int b) {
            System.out.println(a + " + " + b + EQUAL + (a + b));
        }

        public static void subtract(int a, int b) {
            System.out.println(a + " - " + b + EQUAL + (a - b));
        }

        public static void multiply(int a, int b) {
            System.out.println(a + " * " + b + EQUAL + (a * b));
        }

        public static void divide(int a, int b) {
            System.out.println(a + " / " + b + EQUAL + (a / b));
        }

    }
}
