package com.javarush.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    public boolean isMine;
    public boolean isOpen;
    public int countMineNeighbors;

    GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }
}
