package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    private Snake snake;
    private Apple apple;

    private int turnDelay;
    private boolean isGameStopped;
    private static final int GOAL = 28;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        Apple newApple;
        int x = getRandomNumber(WIDTH);
        int y = getRandomNumber(HEIGHT);
        newApple = new Apple(x, y);
        apple = newApple;
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
        }
        if (!snake.isAlive) {
            gameOver();
        }
        if (snake.getLength() > GOAL) {
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "Game over!", Color.RED, 50);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "You win!", Color.GREEN, 50);
    }
}