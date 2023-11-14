package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    public void draw(Game game) {
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }

    private double getLeftBorder() {
        double left = SpaceInvadersGame.WIDTH;
        for (GameObject ship : ships) {
            if (ship.x < left) {
                left = ship.x;
            }
        }
        return left;
    }

    private double getRightBorder() {
        double right = 0;
        for (GameObject ship : ships) {
            if (ship.x + ship.width > right) {
                right = ship.x + ship.width;
            }
        }
        return right;
    }

    private double getSpeed() {
        int count = ships.size();
        double speed = 3. / count;
        return speed > 2. ? 2. : speed;
    }

    public void move() {

    }
}
