package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level) {


        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player;

        int x = Model.FIELD_CELL_SIZE / 2;
        int y = Model.FIELD_CELL_SIZE / 2;

        walls.add(new Wall(x + 0 * Model.FIELD_CELL_SIZE, y));
        walls.add(new Wall(x + 1 * Model.FIELD_CELL_SIZE, y));
        walls.add(new Wall(x + 2 * Model.FIELD_CELL_SIZE, y));

        boxes.add(new Box(x, y + 0 * Model.FIELD_CELL_SIZE));
        homes.add(new Home(x, y + 1 * Model.FIELD_CELL_SIZE));
        player = new Player(x, y + 2 * Model.FIELD_CELL_SIZE);

        return new GameObjects(walls, boxes, homes, player);
    }
}
