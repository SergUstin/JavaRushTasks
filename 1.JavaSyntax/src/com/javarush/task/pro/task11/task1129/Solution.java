package com.javarush.task.pro.task11.task1129;

/* 
Био-Нано-Боты
*/

public class Solution {

    public static Human sysadmin = new Human();

    public static void main(String[] args) {
        sysadmin.load(new Class[]{AlternativeMetal.class, BlackMetal.class, DeathMetal.class,
        DoomMetal.class, FolkMetal.class, GlamMetal.class, GothicMetal.class, HeavyMetal.class,
        IndustrialMetal.class, Metalcore.class, PowerMetal.class, ProgressiveMetal.class,
        SpeedMetal.class, SymphonicMetal.class, ThrashMetal.class});

    }
}
