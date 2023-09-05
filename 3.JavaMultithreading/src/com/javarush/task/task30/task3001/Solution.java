package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {

        Number number = new Number(NumberSystemType._10, "6");
        NumberSystemType expectedNotationType = NumberSystemType._2;
        Number result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        expectedNotationType = NumberSystemType._8;
        result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);   //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        expectedNotationType = NumberSystemType._16;
        result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        checkDataIsValid(number);
        BigInteger result = to10NumberSystem(number);
        return from10TOExpectedNumberSystem(result, expectedNumberSystem);
    }

    private static Number from10TOExpectedNumberSystem(BigInteger number, NumberSystem expectedNumberSystem) {
        if (NumberSystemType._10.equals(expectedNumberSystem)) {
            return new Number(expectedNumberSystem, number.toString());
        } else {
            BigInteger divider = new BigInteger("" + expectedNumberSystem.getNumberSystemIntValue());
            BigInteger dividend = new BigInteger(number.toString());
            String result = "";
            //number is current
            while (dividend.compareTo(BigInteger.ZERO) > 0) {
                BigInteger integer = dividend.divide(divider);
                String s = dividend.subtract(integer.multiply(divider)).toString();
                result = (s.length() == 1 ? s : getChar(s)) + result;
                dividend = integer;
            }
            return new Number(expectedNumberSystem, result);
        }
    }

    private static String getChar(String s) {
        return "" + (char) (Integer.parseInt(s) + 87);
    }

    private static void checkDataIsValid(Number number) {
        if (number.getNumberSystem().getNumberSystemIntValue() <= 10) {
            checkDigitsLimited(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue() + 48);
        } else {
            checkCharsLimited(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue() + 87);
        }
    }

    private static void checkCharsLimited(String digit, int value) {
        for (char c : digit.toCharArray()) {
            if (!(c >= 48 && c <= 57) && !(c >= 97 && c < value)) {
                throw new NumberFormatException();
            }
        }

    }

    private static void checkDigitsLimited(String digit, int value) {
        for (char c : digit.toCharArray()) {
            if (!(c >= 48 && c < value)) {
                throw new NumberFormatException();
            }
        }
    }

    private static BigInteger to10NumberSystem(Number number) {
        BigInteger result;
        if (NumberSystemType._10.equals(number.getNumberSystem())) {
            result = new BigInteger(number.getDigit());
        } else {
            result = BigInteger.ZERO;
            char[] digits = number.getDigit().toLowerCase().toCharArray();

            //to _10 number system
            BigInteger power = new BigInteger("" + number.getNumberSystem().getNumberSystemIntValue());
            BigInteger multiplier = BigInteger.ONE;

            for (int i = digits.length - 1; i >= 0; i--) {
                result = result.add(multiplier.multiply(getData(digits[i])));
                multiplier = multiplier.multiply(power);
            }

        }
        return result;
    }

    private static BigInteger getData(char c) {
        if (c >= '1' && c <= '9' || c == '0')
            return new BigInteger("" + c);
        else return new BigInteger("" + (c - 87));
    }
}
