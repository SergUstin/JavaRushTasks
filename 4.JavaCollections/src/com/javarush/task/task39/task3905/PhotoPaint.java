package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y < 0 || y >= image.length || x < 0 || x >= image[0].length) {
            return false;
        }

        Color originalColor = image[y][x];
        if (originalColor == desiredColor) {
            return false;
        }

        paintFill(image, x, y, desiredColor, originalColor);
        return true;
    }

    private void paintFill(Color[][] image, int x, int y, Color desiredColor, Color originalColor) {
        if (y < 0 || y >= image.length || x < 0 || x >= image[0].length) {
            return;
        }

        if (image[y][x] == originalColor) {
            image[y][x] = desiredColor;
            paintFill(image, x - 1, y, desiredColor, originalColor);
            paintFill(image, x + 1, y, desiredColor, originalColor);
            paintFill(image, x, y - 1, desiredColor, originalColor);
            paintFill(image, x, y + 1, desiredColor, originalColor);
        }
    }

    public void printImage(Color[][] image) {
        if (image == null) {
            return;
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j].ordinal() + " ");
            }
            System.out.println();
        }
    }
}
