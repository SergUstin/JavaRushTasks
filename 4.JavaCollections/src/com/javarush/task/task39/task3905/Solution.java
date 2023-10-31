package com.javarush.task.task39.task3905;

import java.util.Random;

/* 
Залей меня полностью
*/

public class Solution {
    private static Color[][] image = new Color[10][10];

    public static void main(String[] args) {
        PhotoPaint photoPaint = new PhotoPaint();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = Color.values()[new Random().nextInt(Color.values().length)];
            }
        }

        System.out.println("Initial image: ");
        photoPaint.printImage(image);

        photoPaint.paintFill(image, 2, 2, Color.BLUE);
        System.out.println("Modified image: ");
        photoPaint.printImage(image);
    }
}
