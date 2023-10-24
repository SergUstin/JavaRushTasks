package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        List<Integer> list = new ArrayList<Integer>();
        ((LinkedList<Integer>) list).add(3);
    }

    public void methodThrowsNullPointerException() {
        int[] arr = null;
        int i = arr.length;
    }

    public static void main(String[] args) {

    }
}
