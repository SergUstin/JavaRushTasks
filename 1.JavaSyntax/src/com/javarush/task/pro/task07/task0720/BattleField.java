package com.javarush.task.pro.task07.task0720;

/* 
Галавир XIII (3)
*/

public class BattleField {
    public static String nimrodDefence = "Вражеская атака отбита";
    public static String nimrodAttack = "Наносим контр удар";
    public static String nimrodDestroy = "Вражеский удар не выдержан";
    public static String galavirDefence = "Наша атака успешно отражена врагом";
    public static String galavirAttack = "Враг наносит удар";
    public static String galavirDestroy = "Вражеский корабль повержен";

    public static void main(String[] args) {
        GalavirXIII galavirXIII = new GalavirXIII();
        Nimrod nimrod = new Nimrod();
        do {
            System.out.println(galavirAttack);
            int attackGalavir = galavirXIII.attack();
            nimrod.defend(attackGalavir);
            System.out.println("Nimrod health = " + nimrod.health);
            if (nimrod.health > 0) {
                System.out.println(nimrodAttack);
                nimrod.attack();
                galavirXIII.defend(nimrod.attack());
            }
        } while (isGalavirAlive(galavirXIII));
    }

    public static boolean isNimrodAlive(Nimrod nimrod) {
        if (nimrod.health > 0) {
            System.out.println(nimrodDefence);
            return true;
        } else {
            System.out.println(nimrodDestroy);
            return false;
        }
    }

    public static boolean isGalavirAlive(GalavirXIII galavir) {
        if (galavir.health > 0) {
            System.out.println(galavirDefence);
            return true;
        } else {
            System.out.println(galavirDestroy);
            return false;
        }
    }
}
