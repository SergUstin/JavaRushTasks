package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        GameObject gameObject1 = new GameObject(x, y);
        GameObject gameObject2 = new GameObject(x + 1, y);
        GameObject gameObject3 = new GameObject(x + 2, y);
        snakeParts.add(gameObject1);
        snakeParts.add(gameObject2);
        snakeParts.add(gameObject3);
    }
}
