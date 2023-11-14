package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
    }
}
