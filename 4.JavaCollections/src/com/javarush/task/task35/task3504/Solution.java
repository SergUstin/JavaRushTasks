package com.javarush.task.task35.task3504;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* 
Простой generics
*/

public class Solution<T extends HashMap> {
    private T map;

    public Solution(T map) {
        this.map = map;
    }

    public T getMap() {
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("string", 4);
        Solution<HashMap> solution = new Solution<HashMap>(hashMap);
        HashMap mapFromSolution = solution.getMap();
        System.out.println(mapFromSolution.getClass());


        LinkedHashMap<Solution, Solution> hashMap2 = new LinkedHashMap<>();
        hashMap2.put(solution, solution);
        Solution<LinkedHashMap> solution2 = new Solution<LinkedHashMap>(hashMap2);
        LinkedHashMap mapFromSolution2 = solution2.getMap();   //don't need to cast
        System.out.println(mapFromSolution2.getClass());
    }
}
