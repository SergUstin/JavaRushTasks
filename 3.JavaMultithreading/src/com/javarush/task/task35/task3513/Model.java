package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Tile[][] gameTiles;
    private static final int FIELD_WIDTH = 4;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int index = (int) (Math.random() * emptyTiles.size()) % emptyTiles.size();
            Tile emptyTile = emptyTiles.get(index);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        final List<Tile> list = new ArrayList<Tile>();
        for (Tile[] tileArray : gameTiles) {
            for (Tile t : tileArray)
                if (t.isEmpty()) {
                    list.add(t);
                }
        }
        return list;
    }
}
