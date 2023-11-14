package com.javarush.task.task35.task3513;

public class Model {
    private Tile[][] gameTiles;
    private static final int FIELD_WIDTH = 4;

    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
    }
}
