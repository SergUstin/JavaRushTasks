package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;

    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;

    private PlayerShip playerShip;
    private List<Bullet> playerBullets;

    private boolean isGameStopped = false;
    private int animationsCount;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();

        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }

        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (Key.SPACE == key) {
            if (isGameStopped) {
                createGame();
                return;
            }

            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(bullet);
            }
        }

        if (Key.LEFT == key) {
            playerShip.setDirection(Direction.LEFT);
        }

        if (Key.RIGHT == key) {
            playerShip.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (Key.LEFT == key && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        }
        if (Key.RIGHT == key && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color color, String value) {
        if (x > WIDTH - 1 || x < 0 || y < 0 || y > HEIGHT - 1) {
            return;
        }
        super.setCellValueEx(x, y, color, value);
    }

    private void createGame() {
        isGameStopped = false;
        animationsCount = 0;
        score = 0;

        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        playerBullets = new ArrayList<>();

        createStars();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        playerShip.draw(this);

        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }

        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            stars.add(new Star(x, y));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        playerShip.move();

        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.move();
        }

        for (Bullet bullet : playerBullets) {
            bullet.move();
        }
    }

    private void removeDeadBullets() {
        for (Bullet bullet : new ArrayList<>(enemyBullets)) {
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1) {
                enemyBullets.remove(bullet);
            }
        }

        for (Bullet bullet : new ArrayList<>(playerBullets)) {
            if (!bullet.isAlive || bullet.y + bullet.height < 0) {
                playerBullets.remove(bullet);
            }
        }
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();

        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }

        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }

        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();

        if (isWin) {
            showMessageDialog(Color.NONE, "YOU WIN", Color.GREEN, 50);
        } else {
            showMessageDialog(Color.NONE, "GAME OVER", Color.RED, 50);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }
}
