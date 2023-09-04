package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));    //2.3 expected
        System.out.println(getValue(-1.1d, 1.1d));   //0.0 expected
        System.out.println(getValue(.100d, 1.100d)); //1.2 expected
    }

    public static BigDecimal getValue(double v1, double v2) {
        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}
