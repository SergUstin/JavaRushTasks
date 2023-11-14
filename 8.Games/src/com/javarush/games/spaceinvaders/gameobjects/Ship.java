package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex;

    public Ship(double x, double y) {
        super(x, y);
    }

    public Bullet fire() {
        return null;
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(int[][]... viewFrames) {
        setMatrix(viewFrames[0]);

        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    public void nextFrame() {
        frameIndex++;

        if (frameIndex >= frames.size()) {
            return;
        }

        matrix = frames.get(frameIndex);
    }


    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
}
