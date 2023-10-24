package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static void main(String[] args) {
        ABCD_Factory.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
    }

    public static Class getFactoryClass() {
        return ABCD_Factory.class;
    }
}
