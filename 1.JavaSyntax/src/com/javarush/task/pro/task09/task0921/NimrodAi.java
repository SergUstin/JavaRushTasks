package com.javarush.task.pro.task09.task0921;

/* 
Пиратский разворот
*/

import java.util.Arrays;
import java.util.Locale;

public class NimrodAi {
    
    public static void main(String[] args) {
        PastryLoader[] pastryLoaders = new PastryLoader[]{new PastryLoader(), new PastryLoader(), new PastryLoader()};

        scanMemory(pastryLoaders);
        replaceTarget(pastryLoaders);
        scanMemory(pastryLoaders);
    }

    public static void scanMemory(PastryLoader[] pastryLoaders) {
        System.out.println();
        for (PastryLoader pastryLoader : pastryLoaders) {
            System.out.println(Arrays.deepToString(pastryLoader.memory));
        }
    }

    public static void replaceTarget(PastryLoader[] pastryLoaders) {
        for (int i = 0; i < pastryLoaders.length; i++) {
            PastryLoader pastryLoader = pastryLoaders[i];
            String[][][] array = pastryLoader.memory;
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array[j].length; k++) {
                    for (int l = 0; l < array[j][k].length; l++) {
                        String str = array[j][k][l];
                        String lowerCase = str.toLowerCase();
                        if (lowerCase.contains("nimrod")) {
                            array[j][k][l] = lowerCase.replaceAll("nimrod", "pirate ship");
                        }
                    }
                }
            }
        }

    }
}
